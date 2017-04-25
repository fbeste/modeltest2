class Resident {
  public String name;
  private Room assigned_room;

  public Resident(String name) {
    //Constructor
    this.name = name;
  }

  public void assignToRoom(Room room) {
      // assigns a Resident to a Room
    }
}


class Creature extends Resident {
  public void breathe(){}
}

class Human extends Creature  {
  public void checkApartement(Room room) {
    // What is the function of this method?
  }
}

class Animal extends Creature {
  public void adoptToHuman(Human human) {}
}

class Machine extends Resident {
  public void operate() {}
}

class Robot extends Machine implements Detectable {
  public void followInstruction(int instructionID) {}
  public boolean detect() {
    return true;
  }
}



abstract class Door {
  private Room room_a;
  private Room room_b;

  public Door(String material, Room a, Room b) {
    //Constructor
    this.material = material;
    this.room_a = a;
    this.room_b = b;
  }
  public void open() {}
  public void close() {}
  public boolean isOpen() {
    return true;
  }
}

class InnerDoor extends Door {}

class EntranceDoor extends Door {
  private boolean lock_state;
  public void lock() {}
  public void unlock() {}
  public boolean isLocked() {
    return false;
  }
}

class SecurityDoor extends Door {
  public boolean authenticate() {
    return true;
  }
}

class Room {
  private String name;
  public void Room(String name){
    this.name = name;
  }
}

class Headquarter implements Detectable {
  public Room[] rooms;
  private Door[] doors;
  public Headquarter() {
    //Constructor
    // we set up a minimal headquarter

    // first, the rooms
    rooms = new Room[3];
    rooms[0] = new Room("kitchen");
    rooms[1] = new Room("office");
    rooms[2] = new Room("bathroom");

    // then, connect the rooms by doors
    doors = new Door[2];
    doors[0] = (door) new InnerDoor("woodDoor", rooms[0], rooms[1]);
    doors[1] = (door) new InnerDoor("fallTuere", rooms[1], rooms[2]);
  }
  public void hidePerson(Resident resi, Room room) {}
  public boolean isHidden(Resident resi, Room room) {
    return false;
  }
}



interface Detectable {
  // not sure what this should do
  // however, in any class that implements this interface, there must be
  // a matching definition of detect()
  void detect();
}

class Modellierungsaufgabe {
  public static void main(String[] args) {
    Headquarter hq = new Headquarter();
    Human eike = new Human("Eike");
    hq.hidePerson((room)eike, hq.rooms[1]);
  }
}
