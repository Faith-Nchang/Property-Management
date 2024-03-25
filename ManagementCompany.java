/*

 * Description: a blue print of the management company

 * @author Faith Fru Nchang
*/

public class ManagementCompany {
	// constant fields
	public static final int MAX_PROPERTY = 5;
	public static final int MAX_WIDTH = 10;
	public static final int MAX_DEPTH = 10;
	public static final int MIN_MGM_FEE = 0;
	public static final int MAX_MGM_FEE = 100;
	
	// fields
	private String name;
	private String taxID;
	private double mgmFeePer;
	private int numberOfProperties =0;
	private Plot plot;
	private Property[] properties;
	
	
	/**
	 * default constructor
	 */
	public ManagementCompany()
	{
		name ="";
		taxID = "";
		mgmFeePer = 0.0;
		plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
		
	}
	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFeePer
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * 
	 * name - management company name
	 * taxID - taxId of the company
	 * mgmFeePer - management fee percentage
	 * x - The x coordinate of the plot
	 * y - The y coordinate of the plot
	 * width - The width coordinate of the plot
	 * depth - The depth coordinate of the plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth)
	{
		this(name, taxID, mgmFeePer );
		
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * 
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer);
		this.plot = otherCompany.plot;
		
	}
	
	// getters
	
	/**
	 * 
	 * @return name - management company name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return taxID - management company Tax Id
	 */
	public String getTaxID()
	{
		return taxID;
	}
	
	/**
	 * 
	 * @return mgmFeePer - management fee percentage
	 */
	public double getMgmFeePer()
	{
		return mgmFeePer;
	}
	
	/**
	 * 
	 * @return plot - a plot object
	 */
	public Plot getPlot()
	{
		return new Plot(plot);
	}
	
	/**
	 * 
	 * @return properties - array of properties
	 */
	public Property[] getProperties()
	{
		return properties;
	}
	
	/**
	 * 
	 * @return numberOfProperties - all properties in the array
	 */
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	
	/**
	 * 
	 * @return totalRent - sum of the rent of all properties in the properties array
	 */
	public double getTotalRent()
	{
		double totalRent = 0.0;
		for (int property = 0; property < numberOfProperties; property++)
			totalRent +=  properties[property].getRentAmount();
		return totalRent;
	}
	
	/**
	 * 
	 * @return highestRentProperty - property with the highest rent amount
	 */
	public Property getHighestRentPropperty()
	{
		// creates a Property object using the first element in the properties array
		Property highestRentProperty = new Property(properties[0]);
		//  loops through all the elements in the properties array
		for (int property =1; property < numberOfProperties; property++)
		{
			// checks if the rent amount of the current Property object is greater than the highest rent property rent amount
			if (properties[property].getRentAmount() > highestRentProperty.getRentAmount())
				highestRentProperty = new Property(properties[property]);
		}
		return new Property(highestRentProperty);
	}
	
	/**
	 * checks if the management fee is between 0 - 100
	 * @return 
	 */
	public boolean isManagementFeeValid()
	{
		// checks if the mgmFeePer is within 0 - 100
		if (mgmFeePer < MIN_MGM_FEE || mgmFeePer > MAX_MGM_FEE )
			return false;
		return true;
	}
	
	/**
	 * 
	 * @return isFull - verifies if the properties array is full
	 */
	public boolean isPropertiesFull()
	{
		boolean isFull; 
		// checks if the properties array is full (had 5 elements)
		if (numberOfProperties>=MAX_PROPERTY)
			isFull= true;
		else
			isFull = false;
		return isFull;
	}
	
	/**
	 * 
	 * @param name - name of the property
	 * @param city - name of the city the property is located
	 * @param rent - rent amount of the property
	 * @param owner - owner of the property
	 * @return the index the property was added, or -1(if the properties array is full), -2(if property is null), -3(property is not encompassed), -4(if property overlaps another property)
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		// creates a new property object
		Property  property = new Property(name, city, rent, owner);
		// calls DetermineReturnValueOfAddProperty() to add the new property and returns the index if all the requirements are met 
		return DetermineReturnValueOfAddProperty(property);
	
	}
	
	/**
	 * 
	 * @param name - property name
	 * @param city - property city 
	 * @param rent - property rent amount
	 * @param owner - owner of the property
	 * @param x - x coordinate of the plot
	 * @param y - y coordinate of the plot
	 * @param width - width of the plot
	 * @param depth - depth of the plot
	 * @return the index the property was added, or -1(if the properties array is full), -2(if property is null), -3(property is not encompassed), -4(if property overlaps another property)
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return DetermineReturnValueOfAddProperty(property);
	}
	
	/**
	 *  adds a property object to the properties array
	 * @param property - a Property array
	 * @return index where the property was added or -1(if the properties array is full), -2(if property is null), -3(property is not encompassed), -4(if property overlaps another property)
	 */
	public int addProperty(Property property)
	{
		Property prop = new Property(property);
		return DetermineReturnValueOfAddProperty(prop);
	}
	
	/**
	 * determines what value each overloaded addProperty methods will return
	 * @param property - a property object
	 * @return -1(if the properties array is full), -2(if property is null), 
	 * 			-3(property is not encompassed), -4(if property overlaps another property), or the index the object was added
	 */
	public int DetermineReturnValueOfAddProperty(Property property)
	{
		if (isPropertiesFull())
		{
			return -1;
		} else if(property == null)
		{
			return -2;
		}
		else if (!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		else 
		{
			for (int i = 0; i < numberOfProperties; i++)
			{
				if (property.getPlot().overlaps(properties[i].getPlot()))
					return -4;
			}
		}
		
		// creates a copy of the property object and adds it to the array of properties 
		properties[numberOfProperties] = new Property(property);
		//increments the number of properties in the array
		numberOfProperties++;
		// the index the new property was added
		return numberOfProperties - 1;
	}
	
	/**
	 * sets the last element of the properties array to null
	 */
	public void removeLastProperty()
	{
		// sets the last in the properties array to null
		if (numberOfProperties !=0)
		{
			properties[numberOfProperties-1] = null;
			numberOfProperties--;
		}
		
	}
	
	/**
	 * computes the mgmFee of the company
	 * @return mgmFee - the total management fee of the management company
	 */
	public double determineTotalManagementFee()
	{
		// computes the management fee using the total rent of all the properties and the management fee percentage
		double mgmFee = mgmFeePer / 100 * this.getTotalRent();
		return mgmFee;
	}
	
	/**
	 * @return str - list all the properties in the properties array and their attributes
	 */
	public String toString()
	{
		String str = "List of the properties for " + name +", taxID: " + taxID + "\n"
				+ "______________________________________________________\n";
		for (int i =0; i< numberOfProperties; i++)
		{
			str += properties[i].getPropertyName() + "," 
				  + properties[i].getCity() + "," 
				  + properties[i].getOwner() + "," 
				  + properties[i].getRentAmount()+ "\n";
		}
		str += "______________________________________________________\n"
				+ "\n"
				+ " total management Fee: " + determineTotalManagementFee(); // calls determineTotalManagementFee() to get the total management fee
		return str;
	}
}
