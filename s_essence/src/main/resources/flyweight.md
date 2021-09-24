**Flyweight** is a structural design pattern that lets you fit more
objects into the available amount of RAM by sharing common
parts of state between multiple objects instead of keeping all the data in each object.

Simply put, the flyweight pattern is based on a factory which recycles created objects by storing them after creation. Each time an object is requested, the factory looks up the object in order to check if it's already been created. If it has, the existing object is returned – otherwise, a new one is created, stored and then returned.

The flyweight object's state is made up of an invariant component shared with other similar objects (intrinsic) and a variant component which can be manipulated by the client code (extrinsic).

It's very important that the flyweight objects are immutable: any operation on the state must be performed by the factory.