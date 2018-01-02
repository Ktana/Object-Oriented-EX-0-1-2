package Predicate;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Filter implements Serializable{
	boolean TimechkBx;
	String TIME_MinVal;
	String TIME_MaxVal;
	boolean AltchkBx;
	String ALT_MinVal;
	String ALT_MaxVal;
	boolean LATchkBx;
	String LAT_MinVal;
	String LAT_MaxVal;
	boolean LONchkBx;
	String LON_MinVal;
	String LON_MaxVal;
	boolean IDchkBx;
	String ID_MinVal;
	
	public Filter(){
		 this.TimechkBx = false;
		 this.TIME_MinVal = null;
		 this.TIME_MaxVal = null;
		 this.AltchkBx = false;
		 this.ALT_MinVal = null;
		 this.ALT_MaxVal = null;
		 this.LATchkBx = false;
		 this.LAT_MinVal = null;
		 this.LAT_MaxVal = null;
		 this.LONchkBx = false;
		 this.LON_MinVal = null;
		 this.LON_MaxVal = null;
		 this.IDchkBx = false;
		 this.ID_MinVal = null;
	}
	
	public Filter(boolean TimechkBx, String TIME_MinVal, String TIME_MaxVal, boolean AltchkBx, String ALT_MinVal, String ALT_MaxVal, boolean LATchkBx, String LAT_MinVal,
					String LAT_MaxVal, boolean LONchkBx, String LON_MinVal, String LON_MaxVal, boolean IDchkBx, String ID_MinVal){
		
		this.TimechkBx = TimechkBx;
		this.TIME_MinVal = TIME_MinVal;
		this.TIME_MaxVal = TIME_MaxVal;
		
		this.AltchkBx = AltchkBx;
		this.ALT_MaxVal = ALT_MaxVal;
		this.ALT_MinVal = ALT_MinVal;
		
		this.LATchkBx = LATchkBx;
		this.LAT_MaxVal = LAT_MaxVal;
		this.LAT_MinVal = LAT_MinVal;
		
		this.LONchkBx = LONchkBx;
		this.LON_MaxVal = LON_MaxVal;
		this.LON_MinVal = LON_MinVal;
		
		this.IDchkBx = IDchkBx;
		this.ID_MinVal = ID_MinVal;

	}
}
