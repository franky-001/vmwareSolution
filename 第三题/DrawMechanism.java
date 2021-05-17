package vmware;

public class DrawMechanism {

	
	public void draw(IDraw iDraw) {
		preprocessing();
		iDraw.draw();
		postprocessing();

	}
	
	
	public void preprocessing() {
		System.out.println("preprocessing");
	}
	
	public void postprocessing() {
		System.out.println("postprocessing");
	}

}
