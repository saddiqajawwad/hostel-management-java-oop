package final_project;

//Base class (Inheritance demonstration)
	class Room {
		String roomNumber;
		int capacity;

		Room(String roomNumber, int capacity) {
			this.roomNumber = roomNumber;
			this.capacity = capacity;
}

		void showInfo() {
			System.out.println("Room " + roomNumber + " capacity: " + capacity);
}
}

//Derived classes
	class SingleRoom extends Room {
		SingleRoom(String roomNumber) {
			super(roomNumber, 1);
}
}

	class DoubleRoom extends Room {
		DoubleRoom(String roomNumber) {
			super(roomNumber, 2);
}
}

//Abstraction demonstration
	abstract class AllocationPolicy {
		abstract void allocate(student s, Room r);
}

	class FirstComePolicy extends AllocationPolicy {
		@Override
		void allocate(student s, Room r) {
			System.out.println(s.name + " allocated to room " + r.roomNumber );
}
}

//Interface demonstration
	interface FeeManagement {
		double calculateFee(Room r);
}

	class MonthlyFee implements FeeManagement {
		public double calculateFee(Room r) {
			return 5000 * r.capacity; // simple formula
}
}

//Object interaction
	class student {
		String name;
		student(String name) { this.name = name; }
}

	public class Final_project {
		public static void main(String[] args) {
 // Create objects
			student s1 = new student("Rumeesah");
			student s2 = new student("Saddiqa");

			Room r1 = new SingleRoom("101");
			Room r2 = new DoubleRoom("102");

 // Inheritance demo
				r1.showInfo();
				r2.showInfo();

 // Abstraction demo
			AllocationPolicy policy = new FirstComePolicy();
				policy.allocate(s1, r1);
				policy.allocate(s2, r2);

 // Interface demo
			FeeManagement fee = new MonthlyFee();
				System.out.println("Fee for room " + r1.roomNumber + ": " + fee.calculateFee(r1));
				System.out.println("Fee for room " + r2.roomNumber + ": " + fee.calculateFee(r2));
}
}
