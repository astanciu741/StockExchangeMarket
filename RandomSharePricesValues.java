import java.util.*;

/* 1.Construct a list of 100 randomly generated share prices *
* i.create a list of 50 buy orders
* ii.create a list of 50 sell orders
*/
public class RandomSharePricesValues {
	public static ArrayList<Double> generate100ValuesList( ) {
      //Random rand = new Random(); //instance of random class
      int i = 0;
      //define the list that will contain the 100 random generated double values
      ArrayList<Double> list = new ArrayList<Double>();
      
      while(i<100) {
	      double upperbound = 25000;
	      double lowerbound = 1;//because the prize can't be negative
	      //generate random values
	      double double_random = Math.random() * (upperbound - lowerbound + 1) + lowerbound;
	      //double double_random=rand.nextDouble();
	      list.add(double_random);
	      i++;
	  }
      
      
    return list;
	}	
	
	/*.********************Exercise 2***********************
	*Create 3 functions that return the average/minimum/maximum share price
	*I designed the functions to take variable number of parameters because the no of shares might differ in time, so the code can be adaptive 
	*2.1. function for generating the average prize*/
	
	public static double averageSharePrize(double ... args) {
		int i = 0; 
		double averagePrize =0;
		double totalPrice = 0;
		for (double price : args) {
			i++;
		    totalPrice= totalPrice + price;
		    }
		averagePrize = totalPrice/i; 
	    return averagePrize;
	 }	
		
		/*2.2. function for generating the maximum prize*/
		
	    
	public static double maximumSharePrize(double ... args) {
		
		double maximumSharePriceOnMarket = Double.MIN_VALUE;
		
		for (double price : args) {
			
		    if(price > maximumSharePriceOnMarket) {
		    	maximumSharePriceOnMarket = price;
		    }
	   
		}
		return maximumSharePriceOnMarket;
	}
		
		/*2.3. function for generating the minimum prize*/
		
	    
		public static double minimumSharePrize(double ... args) {
			
			double minimumSharePriceOnMarket = Double.MAX_VALUE;
			for (double price : args) {
				
			    if(price < minimumSharePriceOnMarket) {
			    	minimumSharePriceOnMarket = price;
			    }
		   
			}	
			 return minimumSharePriceOnMarket;
	    
	
		}
		public static void main(String... args) {
		
			
			/*/*******************************Exercise 3************************
			 * 3.Model a stock exchange
			 * a.For 30 different stocks
			 * 	i.create a list of 50 buy orders
			 * 	ii.create a list of 50 sell orders */
					
					
			tradingOrders [] buyOrders = new tradingOrders [50];
			tradingOrders [] sellOrders = new tradingOrders [50];
			 
			for (int i = 0; i < 51; i++)
			{
			    //generate input variables;
				double IDofStockSell = 0;
				double IDofStockBuy = 0;
				double sellPrice = 0;
				double buyPrice = 0;
				double noOfStocksDemandedBuy = 0;
				double noOfStocksDemandedSell = 0;
				//generating IDs for stocks
				double upperbound = 60;
			    double lowerbound = 1;
			    double double_randomSell = Math.random() * (upperbound - lowerbound + 1) + lowerbound;	
			    double double_randomBuy = Math.random() * (upperbound - lowerbound + 1) + lowerbound;	
			    IDofStockSell = double_randomSell;
			    IDofStockBuy = double_randomBuy;
			    
			  //generating Sell and Buy prices for stocks
				double upperbound2 = 2000;
			    double lowerbound2 = 1;
			    double double_randomSell2 = Math.random() * (upperbound2 - lowerbound2 + 1) + lowerbound2;	
			    double double_randomBuy2 = Math.random() * (upperbound2 - lowerbound2 + 1) + lowerbound2;	
			    sellPrice = double_randomSell2;
			    buyPrice = double_randomBuy2;
			
			    //generating noOfStocksDemanded
				double upperbound3 = 15000;
			    double lowerbound3 = 1;
			    double random3 = Math.random() * (upperbound3 - lowerbound3 + 1) + lowerbound3;	
			    double random4 = Math.random() * (upperbound3 - lowerbound3 + 1) + lowerbound3;
			    noOfStocksDemandedBuy = random3;
			    noOfStocksDemandedSell = random4;
			    /* 	i.create a list of 50 buy orders
			    * 	ii.create a list of 50 sell orders*/
			    buyOrders[i] = new tradingOrders(IDofStockBuy, buyPrice,noOfStocksDemandedBuy);
			    sellOrders[i] = new tradingOrders(IDofStockSell, sellPrice,noOfStocksDemandedSell);
			}
		
		}

		private static void matchBuyerAndSeller(tradingOrders[] buyOrders, tradingOrders[] sellOrders) {
			double noOfStocksExchanged = 0;
			for (int i = 0; i<= buyOrders.length; i++) {
				for (int j = 0; i<= sellOrders.length; j++) {
					//verifying the IDs
					if ((buyOrders[i].IDofStock == sellOrders[j].IDofStock) & (buyOrders[i].buyPrice >= sellOrders[j].sellPrice)) {
						if (sellOrders[j].noOfStocksDemanded > buyOrders[i].noOfStocksDemanded) {
							 noOfStocksExchanged = buyOrders[i].noOfStocksDemanded;
						}else if (sellOrders[j].noOfStocksDemanded < buyOrders[i].noOfStocksDemanded) {
							 noOfStocksExchanged = sellOrders[j].noOfStocksDemanded;
						}else {noOfStocksExchanged = sellOrders[j].noOfStocksDemanded;}
						System.out.println(" The Buyer " + buyOrders[i].IDofStock + " buyed " + noOfStocksExchanged + "stocks, from the seller: " + sellOrders[j].IDofStock);
					} 
					
				}
				
			}
			
		}
		
		//matchBuyerAndSeller(buyOrders, sellOrders)
		
}
		

		
//A stock class that holds the information of a stock like: buy orders, sell orders, id, etc
class Stock {
	//the properties of a stock
	double ID;
	String name;
	double pricePerStock, noOfStocksAvailable, noOfStocksDemanded, taxes;
	
	//creating a default constructor
		public Stock() {
			
		}
			
		//creating a constructor with the properties of a stock
		public Stock(double ID, String name, double pricePerStock, double noOfStocksAvailable, double noOfStocksDemanded, double taxes) {
			this.ID= ID;
			this.name = name;
			this.noOfStocksAvailable = noOfStocksAvailable;
			this.noOfStocksDemanded = noOfStocksDemanded;
			this.pricePerStock = pricePerStock;		
			this.taxes = taxes;
		}
	
}

class tradingOrders {
	public double sellPrice;//the price of the stock that determines me to sell the stock
	public double buyPrice; //the price of the stock that determines me to buy the stock
	public double noOfStocksDemanded;// how many stocks to buy/sell
	public double IDofStock; //to identify the stock to be bought/sold
	
	//constructor for stocks to be sold
	public tradingOrders(double IDofStock, double sellPrice,double noOfStocksDemanded) {
		this.IDofStock= IDofStock;
		this.sellPrice = sellPrice;
		this.noOfStocksDemanded = noOfStocksDemanded;
	}
}


class MarketPlace {
	/* Create a class that has methods to:
	   i.match buyers with sellers 
	   ii.return the minimum order price per stock
	   iii.return the maximum order price per stock
	   iv.return the average order price per stock*/
	
	
	//i.match buyers with sellers 
	
	//sellOrders[i] = new tradingOrders(IDofStockSell, sellPrice,noOfStocksDemandedSell);
    //buyOrders[i] = new tradingOrders(IDofStockBuy, buyPrice,noOfStocksDemandedBuy);
	
	
	// method that return the minimum order price per stock
		public static double minimumOrderPrizePerStock(double ... prices) { //the parameters will be variebles 	
			double minimumOrderPrizePerStock = 0;
			
			for (double price : prices) {
				
			    if(price < minimumOrderPrizePerStock) {
			    	minimumOrderPrizePerStock = price;
			    }
			}		
		return minimumOrderPrizePerStock;
		}
		
	
		
	// method that return the maximum order price per stock
		public static double maximumOrderPrizePerStock(double ... prices) { //the parameters will be variebles 	
			double maximumOrderPrizePerStock = 0;
			
			for (double price : prices) {
				
			    if(price > maximumOrderPrizePerStock) {
			    	maximumOrderPrizePerStock = price;
			    }
			}		
			return maximumOrderPrizePerStock;
		} 
		
		// method that return the average order price per stock
		
		
		public static double averageOrderPrizePerStock(double ... args) {
			int i = 0; 
			double averagePrizeStock =0;
			double totalPriceStock = 0;
			for (double price : args) {
				i++;
			    totalPriceStock= totalPriceStock + price;
			    }
			averagePrizeStock = totalPriceStock/i; 
		    return averagePrizeStock;
		 }	
		
		
		
		
		}





