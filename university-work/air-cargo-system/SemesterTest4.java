import java.text.DecimalFormat;
import java.util.Scanner;
public class SemesterTest4
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		DecimalFormat ft = new DecimalFormat("#.00");
		String sCargoType, sChoice;
		String sPerishable = "Perishable";
		String sNormal = "Normal";
		String sDangerous = "Dangerous";
		final double DISTANCE_SURCHARGE = 5.5;
		final double ADDITIONAL_CHARGES = 450.00;
		final double SMALL_PACKAGES = 23.45;//per kg
		final double LARGER_SHIPMENTS = 18.10;//per kg
		final double BULK_SHIPMENTS = 10.55;//perkg
		double rDistance,rTypeMultiplier = 0,rMultiplier = 0, rWeight,rBaseCost = 0, rDistanceSurcharge = 0, rTotal = 0;
		do
		{
			System.out.println("Enter package weight (in kg): ");
			rWeight = kb.nextDouble();
			System.out.println("Enter distance to be traveled (in km): ");
			rDistance = kb.nextDouble();
			System.out.print("Enter cargo type (normal, perishable, Dangerous): ");
			sCargoType = kb.next();
			sCargoType = sCargoType.toLowerCase();
			
			//Calculations
			//Base cost
			if(rWeight < 10)//Small packages
			{
				rBaseCost = rWeight * SMALL_PACKAGES;
				
			}
			else if(rWeight >= 10 && rWeight <= 100)//Larger shipments
			{
				rBaseCost = rWeight * LARGER_SHIPMENTS;
			}
			else if(rWeight > 100)//BULK_SHIPMENTS
			{
				rBaseCost = rWeight * BULK_SHIPMENTS;
			}
		
			if(null != sCargoType)
			//CargoTypeMultiplier
                    switch (sCargoType) {
                        case "normal":
                            rTypeMultiplier = 1.0;
                            break;
                        case "Perishable":
                            rTypeMultiplier = 1.2;
                            break;
                        case "Dangerous":
                            rTypeMultiplier = 1.5;
                            break;
                        default:
                            break;
                    }
			
			//rDistanceSurcharge
			if(rDistance > 500)
			{
				rDistanceSurcharge = rDistance * DISTANCE_SURCHARGE;
			}
			rMultiplier = rTypeMultiplier * rBaseCost;
			
			//Total
			rTotal = rMultiplier + ADDITIONAL_CHARGES + rDistanceSurcharge;
			System.out.println("Air Cargo Cost Estimation Summary: ");
			System.out.println("----------------------------------------------");
			System.out.println("Package weight\t\t: " + rWeight);
			System.out.println("Distance to be traveled\t: " + rDistance + " km");
			System.out.println("Cargo Type\t\t: " + sCargoType);
			System.out.println("Base Cost\t\t: R" + ft.format(rBaseCost));
			System.out.println("Cargo Type Multiplier\t: " + rTypeMultiplier);
			System.out.println("Distance surcharge\t: " + rDistanceSurcharge);
			System.out.println("Additional charges (Hnadling & Fuel)\t: R" + ADDITIONAL_CHARGES);
			System.out.println("----------------------------------------------");
			System.out.println("Total Estimated Air Cargo Cost: R" + rTotal);
			System.out.println("----------------------------------------------");
			System.out.println("Would you like to calculate the cost for another package? (Y<es>/N)");
			sChoice = kb.next();
		}
		while(!(sChoice.equalsIgnoreCase("No")));
		
	}
}
