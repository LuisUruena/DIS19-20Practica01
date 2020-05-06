
public class Localizacion 
{
	
	private int pasillo;
	private int estanteria;
	private int estante;

	public Localizacion(int pasillo, int estanteria, int estante) 
	{
		this.pasillo = pasillo;
		this.estanteria = estanteria;
		this.estante = estante;
	}

	public int getPasillo() {
		return pasillo;
	}

	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}

	public int getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}

	public int getEstante() {
		return estante;
	}

	public void setEstante(int estante) {
		this.estante = estante;
	}
	
	@Override
	public String toString() 
	{
		return "Pasillo: " + pasillo + "\nEstantería: " + estanteria + "\nEstante: " + estante;
	}

}
