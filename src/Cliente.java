
public class Cliente {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String telefonoContacto;
	private Direccion direccion;
	

	public Cliente(String nombre, String apellidos, String email, String telefonoContacto, Direccion direccion) 
	{
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefonoContacto = telefonoContacto;
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefonoContacto() {
		return telefonoContacto;
	}


	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() 
	{
		return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nEmail: " + email + "\nTeléfono de contacto: " + telefonoContacto + "\nDirección: " + direccion.toString();
	}
	
	

}
