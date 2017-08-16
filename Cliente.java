public class Cliente {

	private String nombre;
	private String telefono;
	private String direccion;
	private String correo;
	private float metrosPropiedad;
	private float valorPropiedad;
	private float ventaPropiedad;

	public Cliente(String name, String phone, String address, String email, float meters, float value, float price) {
		setNombre(name);
		setTelefono(phone);
		setDireccion(address);
		setCorreo(email);
		setMetrosPropiedad(meters);
		setValorPropiedad(value);
		setVentaPropiedad(price);
	}

	public Cliente(Cliente nuevo) {
		setNombre(nuevo.getNombre());
		setTelefono(nuevo.getTelefono());
		setDireccion(nuevo.getDireccion());
		setCorreo(nuevo.getCorreo());
		setMetrosPropiedad(nuevo.getMetrosPropiedad());
		setValorPropiedad(nuevo.getValorPropiedad());
		setVentaPropiedad(nuevo.getVentaPropiedad());
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public void setTelefono(String phone) {
		this.telefono = phone;
	}

	public void setDireccion(String address) {
		this.direccion = address;
	}
	
	public void setCorreo(String email) {
		this.correo = email;
	}

	public void setMetrosPropiedad(float meters) {
		this.metrosPropiedad = meters;
	}

	public void setValorPropiedad(float value) {
		this.valorPropiedad = value;
	}

	public void setVentaPropiedad(float price) {
		this.ventaPropiedad = price;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public float getMetrosPropiedad() {
		return metrosPropiedad;
	}

	public float getValorPropiedad() {
		return valorPropiedad;
	}

	public float getVentaPropiedad() {
		return ventaPropiedad;
	}

}