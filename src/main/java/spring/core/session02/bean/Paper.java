package spring.core.session02.bean;

public class Paper {
	private Integer id; // 紙張編號
	private Color color; // 紙張顏色
	private Size a4; // 紙張尺寸
	
	public Paper() {
		
	}

	public Paper(Color color, Size a4) {
		this.color = color;
		this.a4 = a4;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getA4() {
		return a4;
	}

	public void setA4(Size a4) {
		this.a4 = a4;
	}

	@Override
	public String toString() {
		return "Paper [id=" + id + ", color=" + color + ", size=" + a4 + "]";
	}
	
	
}
