package Practice;

public class Practice1 {

	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();

	}

}

class TV {
	private int size;

	public TV(int size) {
		this.size = size;
	}

	protected int getSize() {
		return size;
	}
}

class ColorTV extends TV {
	private int numColor;

	public ColorTV(int size, int numColor) {
		super(size);
		this.numColor = numColor;
	}

	public void printProperty() {
		System.out.println(getSize() + "인치 " + numColor + "컬러");
	}

	public int getColor() {
		return numColor;
	}
}
