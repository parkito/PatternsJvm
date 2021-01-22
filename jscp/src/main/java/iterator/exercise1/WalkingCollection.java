/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package iterator.exercise1;

import java.util.*;
import java.util.concurrent.locks.*;
import java.util.function.*;

public class WalkingCollection<E>
    extends AbstractCollection<E> {
    private final Collection<E> wrappedCollection;
    private final ReentrantReadWriteLock rwlock =
        new ReentrantReadWriteLock();

    public WalkingCollection(Collection<E> wrappedCollection) {
        this.wrappedCollection = wrappedCollection;
    }

    public void iterate(Processor<? super E> processor) {
        rwlock.readLock().lock();
        try {
            for (E e : wrappedCollection) {
                if (!processor.process(e)) return;
            }
        } finally {
            rwlock.readLock().unlock();
        }
    }

    public Iterator<E> iterator() {
        rwlock.readLock().lock();
        try {
            Iterator<E> it = wrappedCollection.iterator();
            return new Iterator<>() {
                public boolean hasNext() {
                    rwlock.readLock().lock();
                    try {
                        return it.hasNext();
                    } finally {
                        rwlock.readLock().unlock();
                    }
                }

                public E next() {
                    rwlock.readLock().lock();
                    try {
                        return it.next();
                    } finally {
                        rwlock.readLock().unlock();
                    }
                }

                public void remove() {
                    checkReadLockStatus();
                    rwlock.writeLock().lock();
                    try {
                        it.remove();
                    } finally {
                        rwlock.writeLock().unlock();
                    }
                }
            };
        } finally {
            rwlock.readLock().unlock();
        }
    }

    private void checkReadLockStatus() {
        if (rwlock.getReadHoldCount() > 0)
            throw new IllegalMonitorStateException(
                "tried to upgrade read lock to write lock"
            );
    }

    public int size() {
        rwlock.readLock().lock();
        try {
            return wrappedCollection.size();
        } finally {
            rwlock.readLock().unlock();
        }
    }

    public boolean add(E e) {
        checkReadLockStatus();
        rwlock.writeLock().lock();
        try {
            return wrappedCollection.add(e);
        } finally {
            rwlock.writeLock().unlock();
        }
    }
}
