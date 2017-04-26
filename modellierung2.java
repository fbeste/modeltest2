class Resident {
    protected String name;
    protected Room current_room;

    public Resident(String name) {
    //Constructor
        this.name = name;
    }

    public void assignToRoom(Room room) {
    // assigns a Resident to a Room
    // for initial setup, overrides traps etc
    }

    public void goToRoom(Room room) {
    // go to the adjacent room
    }
}


class Creature extends Resident {
    public void breathe() {

    }
}

class Human extends Creature  {
    public Resident[] checkRoom(Room room) {
    // find the residents in this room
    }
}

class Animal extends Creature {
    private Human owner;
    public void adoptToHuman(Human human) {
        this.owner = human;
    }
}

class Machine extends Resident {
    public void operate() {}
}

class Robot extends Machine implements Detectable {
    public void followInstruction(int instructionID) {
    }
}

interface SecurityLock {
  boolean authenticate(String code);
}


class Room {
  public String name;
  public void Room(String name){
  // Constructor
      this.name = name;
  }
}


abstract class Door {
    protected boolean open_state;
    public String material;

    public Door(String material) {
    //Constructor
        this.material = material;
    }
    public void open() {}
    public void close() {}
    public boolean isOpen() {
        return true;
    }
}

class InnerDoor extends Door {
    protected Room room_a;
    protected Room room_b;
    InnerDoor(String material, Room room_a, Room room_b) {
    // Constructor
    }
}

class TrapDoor extends InnerDoor {
    // needs to check if the door can be operated from this side
    // it can only be operated from room_a
    private boolean canBeOperated(Room room) {
        return true;
    }
    public void open(Room room) {}
    public void close(Room room) {}
}

class InnerSecurityDoor extends InnerDoor implements SecurityLock {
    public boolean authenticate(String code) {
        return true;
    }
}

class EntranceDoor extends Door implements SecurityLock {
  private boolean lock_state;
  protected Room room;
  public void lock() {}
  public void unlock() {}
  public boolean isLocked() {
      return false;
  }
  public boolean authenticate(String code) {
      return true;
  }
}

class SecurityDoor extends Door {
  public boolean authenticate() {
    return true;
  }
}


class Headquarter {
    public Room[] rooms;
    private Door[] doors;
    public Headquarter() {
    //Constructor
    // we set up a minimal headquarter

        // first, the rooms
        rooms = new Room[4];
        rooms[0] = new Room("hall");
        rooms[1] = new Room("office");
        rooms[2] = new Room("bathroom");
        rooms[3] = new Room("traproom");

        // then, connect the rooms by doors
        doors = new Door[3];
        doors[0] = (door) new EntranceDoor("steel", rooms[0]);
        doors[1] = (door) new InnerDoor("wood", rooms[0], rooms[1]);
        doors[2] = (door) new InnerDoor("wood", rooms[0], rooms[2]);
        doors[3] = (door) new TrapDoor("steel", rooms[2], rooms[3]);
    }
    public void hidePerson(Resident resi, Room room) {}
    public boolean isHidden(Resident resi, Room room) {
        return false;
    }
}



class Modellierungsaufgabe {
    public static void main(String[] args) {
        Headquarter hq = new Headquarter();
        Human eike = new Human("Eike");
        hq.hidePerson((room)eike, hq.rooms[1]);
    }
}
