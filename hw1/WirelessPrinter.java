package hw1;
/**
 * 
 * @author isaacplambeck
 * This class represents a wireless printer.
 * Holds paper and ink, it also can give # of paper and Ink levels.
 */
public class WirelessPrinter {

	/*
	 * Amount of ink in printer
	 */
	private double ink;
	
	/*
	 * Amount of paper in printer
	 */
	private int paper;
	
	/*
	 * Amount of paper used
	 */
	private int paperUsed;
	
	/*
	 * Amount of pages printed with ink.
	 */
	private int pagesPrinted;
	
	/*
	 * the power status of the printer
	 */
	private boolean isOn;
	
	/*
	 * Wireless connection status of the printer
	 */
	private boolean isConnected;
	
	/*
	 * How many pages can be printed from 1 ink cartridge
	 */
	public static final int PAGES_PER_CARTRIDGE = 1000;
	
	/*
	 * How much paper the printer can hold
	 */
	public static final int TRAY_CAPACITY = 500;
	
	/*
	 * The level of an ink in a cartridge
	 */
	public static final double NEW_CARTRIDGE_INK_LEVEL = 1.0;
	
	
	/*
	 * This constructs a new printer
	 */
	public WirelessPrinter() {
		paper = 0;
		ink = 0.5;
	}
	
	/*
	 * Constructs the printer with given ink and given paper.
	 * @param givenInk, givenPaper
	 * the ink in the printer, the paper in the printer
	 */
	public WirelessPrinter(double givenInk, int givenPaper) {
		ink = givenInk;
		paper = givenPaper;
		
	}
	
	
	
	
	/*
	 * Determines if the printer can print
	 * @return
	 * 	true if on, false if off
	 */
	public boolean isOn() {
		// can print only if on
		return isOn;
	}
	
	/*
	 * Determines if the printer is connected to wireless
	 * @return
	 * 	true if connected, false if disconnected
	 */
	public boolean isConnected() {
		// can print only if connected to wireless
		return isConnected;
	}
	
	/*
	 * how much paper is in the printer, in percentage, is left, 
	 * rounded to the nearest percentage.
	 * @return 
	 * 	paper in a percent
	 */
	public int getPaperLevel() {
		//amount of paper in the printer, times 100, 
		//then divided by the amount the printer can hold(500)
		return paper*100/TRAY_CAPACITY;
	}
	
	/*
	 * The current ink level in the printer
	 * @return
	 * 	Ink level in a double value (0.0-1.0)
	 */
	public double getInkLevel() {
		// current ink level
		return ink;
	}
	
	/*
	 * Gets total number of printed with ink by multiplying the inkUsed by the PAGES PER CART(1000)
	 * @return
	 * 	 Pages printed with ink
	 */
	public int getTotalPagesPrinted() {
		// pages printed with ink
		return pagesPrinted;
	}
	
	/*
	 * Gets total number of paper printed by taking the inputed number or the paper, whichever is smaller
	 * @return 
	 * 	The total paper printer (with/without ink)
	 */	
	public int getTotalPaperUsed() {
		// return the number of pages of paper used
		return paperUsed;
	}
	
	/*
	 * The amount of paper left in the tray after a print
	 * @return
	 * 	The current value of paper
	 */
	public int getPaperLevelExact() {
		// current value of paper
		return paper;
	}
	
	
	
	
	
	
	/*
	 * Turn the printer on and connect to the network
	 */
	public void turnOn() {
		// true if on, false if off
		isOn = true;
		// true if connected to the network, false if not
		isConnected = true;
	}
	
	/*
	 * Print certain number of pages
	 * @param pages
	 * 	The amount of pages to print
	 */
	public void print(int pages) {
		//only print if connected to the network
		if (!isConnected())
			return; // do nothing
		//shows the amount of paper used, either how much the value of paper is or
		//how many pages were added to the printer, whichever is smaller
		paperUsed = paperUsed + Math.min(pages, paper);
		//sets inkUsed equal to either how much the value of paper is or
		//how many pages were added to the printer, whichever is smaller
		//then divided by PAGES PER CART, which is 1000
		double inkUsed = (double) Math.min(pages, paper)/PAGES_PER_CARTRIDGE;
		//sets the current value of paper equal to the current value of paper 
		//minus the given amount of pages to print or 0, whichever is bigger
		//if 0 then don't print
		paper = Math.max(paper - pages, 0);
		//sets the amount of ink in the printer to the already amount of ink 
		//minus how much ink was used or 0 if ink-inkUsed is less than 0 (a negative number)
		ink = Math.max(ink-inkUsed, 0);
		//sets pagesPrinted equal to the amount of pages printer added to the amount of ink
		//used in the print times PAGES PER CART(1000)
		pagesPrinted = pagesPrinted +(int)(inkUsed*PAGES_PER_CARTRIDGE);
		
		
		
	}
	
	/*
	 * Load paper into the printer
	 * @param givenPaper
	 *  amount of paper to be loaded into the printer
	 */
	public void loadPaper(int givenPaper) {
		//paper equal to the TRAY CAP(500) or current value of paper added to the paper loaded
		//whichever is smaller
		paper = Math.min(TRAY_CAPACITY, paper + givenPaper);
	}
	
	/*
	 * Connect the printer to the network
	 */
	public void connect() {
		//Printer connected to network if true, if not, false
		isConnected = true;
	}
	
	/*
	 * disconnect the wireless connection
	 */
	public void disconnect() {
		//Printer connected to network if true, if not, false
		isConnected = false;
	}
	
	/*
	 * Replace the Cartridge
	 * set current valve of ink to 1.0
	 */
	public void replaceCartridge(){
		//sets current valve of ink to 1.0
		ink = NEW_CARTRIDGE_INK_LEVEL;
	}
	
	/*
	 * Turn the printer off and disconnect the wireless connection
	 */
	public void turnOff() {
		//Printer is on if true, false if off
		isOn = false;
		//Printer connected to network if true, if not, false
		isConnected = false;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
