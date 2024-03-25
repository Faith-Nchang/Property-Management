/*
 * Description: a blueprint of the properties in the management company
 * @author Faith Fru Nchang
*/

public class Property {
	// fields
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	
	// no - arg constructor
	public Property()
	{
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0.0;
		plot = new Plot();
	}
	
	/**
	 * Constructor
	 * @param propertyName - name of property
	 * @param city - city location of the property
	 * @param rentAmount - amount of rent of the property
	 * @param owner - owner of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 * Constructor
	 * @param propertyName - name of property
	 * @param city - city location of the property
	 * @param rentAmount - amount of rent of the property
	 * @param owner - owner of the property
    */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		// calls another constructor
		this(propertyName, city, rentAmount, owner);
		plot = new Plot(x, y, width, depth);
	}
	
	/*
	 * constructor
	 * @param otherPlot - a Plot object
	 */
	public Property(Property otherProperty)
	{
		this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner);
		this.plot = otherProperty.plot;

	}
	
	//  Accessors
	
	/*
	 * @return propertyName
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/*
	 * @return city
	 */
	public String getCity()
	{
		return city;
	}
	
	/*
	 * @return rentAmount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	/*
	 * @return owner
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/*
	 * @return plotObject
	 */
	public Plot getPlot()
	{
		return new Plot(plot);
	}
	
	
	// setters
	/**
	 * 
	 * @param name - propertyName
	 */
	public void setPropertyName(String name)
	{
		this.propertyName = name;
	}
	/**
	 * 
	 * @param city - city location of the property
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * 
	 * @param rent - rentAmount of the property
	 */
	public void setRentAmount(double rent)
	{
		this.rentAmount = rent;
	}
	
	public void setPlot(Plot otherPlot)
	{
		plot = new Plot(otherPlot);
	}
	
	public String toString()
	{
		String str = propertyName + "," + city +","+ owner+","+rentAmount;
		return str;
	}
}
