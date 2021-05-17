package vmware;

public class TestDraw {

	public static void main(String[] args) {
		DrawMechanism draw=new DrawMechanism();
		IDraw circle=new Circle();
		IDraw square=new Square();
		
		draw.draw(circle);
		draw.draw(square);

	}

}
