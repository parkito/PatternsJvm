/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package observer.exercise1;


import java.io.*;
import java.util.*;
import java.util.concurrent.*;

// run this class first to set up stock file
public class StockTicker extends Observable {
    private final Map<String, Double> shares =
        new ConcurrentHashMap<>();

    public void start() {
        ScheduledExecutorService timer =
            Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(() -> {
            try {
                readFile();
            } catch (Exception e) {
                System.err.println("Problem reading file: " + e);
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(
            new FileReader("stocks.csv"));
        String s;
        while ((s = in.readLine()) != null) {
            String data[] = s.split(",");
            if (data.length == 2) {
                String share = data[0];
                Double price = Double.valueOf(data[1]);
                Double current = shares.get(share);
                if (!price.equals(current)) {
                    shares.put(share, price);
                    setChanged();
                    notifyObservers(new SharePrice(share, price));
                }
            }
        }
        in.close();
    }

    public static void main(String... args)
        throws IOException {
        PrintWriter out = new PrintWriter("stocks.csv");
        out.println("WEZ,9.03");
        out.println("DID,12.33");
        out.println("TEL,45.12");
        out.close();
    }
}
