package src;

/*
 equations used within this code were gathered from previous work in colorimetry
 which were originally gathered from the http://www.brucelindbloom.com/ website
 the code is further explained in the associated documents on the Z drive
 any questions can be referred to Zach Redcay
 a working version is saved within the https://github.com/zredcay/Colorimeter-Calibration
 Github Repo, to ensure version control any changes should be reviewed before 
 being committed and pushed to the repo
 */
public class CalibrationMethod {
	//Variables
	
	//Data vars
	private Double[][] rawData;
	private Double[][] altData;
	
	//Offset vars
	private Double[] addOffset;
	private Double[] multOffset;
	private Double[] expOffset;
	
	//Delta E/RGB vars
	private Double[] deltaE;
	private Double[][] deltaRGB;
	private Double avgDeltaE;
	
	//RGB vals
	private Double[] maxRGB;
	private Double[] calR;
	private Double[] calG;
	private Double[] calB;
	private Double[] realR;
	private Double[] realG;
	private Double[] realB;
	
	//CIELAB vars
	private Double[] calLStar;
	private Double[] calAStar;
	private Double[] calBStar;
	private Double[] realLStar;
	private Double[] realAStar;
	private Double[] realBStar;
	
	//XYZ vars
	private Double[] x;
	private Double[] y;
	private Double[] z;
	private Double[] varX;
	private Double[] varY;
	private Double[] varZ;
	
	//conversion tables
	private Double[][] xyzToRGB;
	private Double[][] specToXYZ;
	
	//run counter
	private int numRuns;
	
	//calibration step vars
	private Double addStep;
	private Double multStep;
	private Double expStep;
	
	//Constructor
	public CalibrationMethod(Double[][] rawData, Double[][] altData, Double[] addOffset,
			Double[] multOffset, Double[] expOffset, Double[] deltaE, Double[][] deltaRGB, Double avgDeltaE, Double[] maxRGB, Double[] calR, Double[] calG, Double[] calB,
			Double[] realR, Double[] realG, Double[] realB, Double[] calLStar, Double[] calAStar, Double[] calBStar,
			Double[] realLStar, Double[] realAStar, Double[] realBStar, Double[] x, Double[] y, Double[] z,
			Double[] varX, Double[] varY, Double[] varZ, Double[][] xyzToRGB, Double[][] specToXYZ, int numRuns,
			Double addStep, Double multStep, Double expStep) {
		super();
		this.rawData = rawData;
		this.altData = altData;
		this.addOffset = addOffset;
		this.multOffset = multOffset;
		this.expOffset = expOffset;
		this.deltaE = deltaE;
		this.deltaRGB = deltaRGB;
		this.avgDeltaE = avgDeltaE;
		this.maxRGB = maxRGB;
		this.calR = calR;
		this.calG = calG;
		this.calB = calB;
		this.realR = realR;
		this.realG = realG;
		this.realB = realB;
		this.calLStar = calLStar;
		this.calAStar = calAStar;
		this.calBStar = calBStar;
		this.realLStar = realLStar;
		this.realAStar = realAStar;
		this.realBStar = realBStar;
		this.x = x;
		this.y = y;
		this.z = z;
		this.varX = varX;
		this.varY = varY;
		this.varZ = varZ;
		this.xyzToRGB = xyzToRGB;
		this.specToXYZ = specToXYZ;
		this.numRuns = numRuns;
		this.addStep = addStep;
		this.multStep = multStep;
		this.expStep = expStep;
	}
	
	//Getters
	public Double[][] getRawData() {
		return rawData;
	}
	public Double[][] getAltData() {
		return altData;
	}
	public Double[] getAddOffset() {
		return addOffset;
	}
	public Double[] getMultOffset() {
		return multOffset;
	}
	public Double[] getExpOffset() {
		return expOffset;
	}
	public Double[] getDeltaE() {
		return deltaE;
	}
	public Double[][] getDeltaRGB() {
		return deltaRGB;
	}
	public Double getAvgDeltaE() {
		return avgDeltaE;
	}
	public Double[] getMaxRGB() {
		return maxRGB;
	}
	public Double[] getCalR() {
		return calR;
	}
	public Double[] getCalG() {
		return calG;
	}
	public Double[] getCalB() {
		return calB;
	}
	public Double[] getRealR() {
		return realR;
	}
	public Double[] getRealG() {
		return realG;
	}
	public Double[] getRealB() {
		return realB;
	}
	public Double[] getCalLStar() {
		return calLStar;
	}
	public Double[] getCalAStar() {
		return calAStar;
	}
	public Double[] getCalBStar() {
		return calBStar;
	}
	public Double[] getRealLStar() {
		return realLStar;
	}
	public Double[] getRealAStar() {
		return realAStar;
	}
	public Double[] getRealBStar() {
		return realBStar;
	}
	public Double[] getX() {
		return x;
	}
	public Double[] getY() {
		return y;
	}
	public Double[] getZ() {
		return z;
	}
	public Double[] getVarX() {
		return varX;
	}
	public Double[] getVarY() {
		return varY;
	}
	public Double[] getVarZ() {
		return varZ;
	}
	public Double[][] getXYZToRGB() {
		return xyzToRGB;
	}
	public Double[][] getSpecToXYZ() {
		return specToXYZ;
	}
	public int getNumRuns() {
		return numRuns;
	}
	public Double getAddStep() {
		return addStep;
	}
	public Double getMultStep() {
		return multStep;
	}
	public Double getExpStep() {
		return expStep;
	}
	
	//Setters
	public void setRawData(Double[][] rawData) {
		this.rawData = rawData;
	}
	public void setAltData(Double[][] altData) {
		this.altData = altData;
	}
	public void setAddOffset(Double[] addOffset) {
		this.addOffset = addOffset;
	}
	public void setMultOffset(Double[] multOffset) {
		this.multOffset = multOffset;
	}
	public void setExpOffset(Double[] expOffset) {
		this.expOffset = expOffset;
	}
	public void setDeltaE(Double[] deltaE) {
		this.deltaE = deltaE;
	}
	public void setDeltaRGB(Double[][] deltaRGB) {
		this.deltaRGB = deltaRGB;
	}
	public void setAvgDeltaE(Double avgDeltaE) {
		this.avgDeltaE = avgDeltaE;
	}
	public void setMaxRGB(Double[] maxRGB) {
		this.maxRGB = maxRGB;
	}
	public void setCalR(Double[] calR) {
		this.calR = calR;
	}
	public void setCalG(Double[] calG) {
		this.calG = calG;
	}
	public void setCalB(Double[] calB) {
		this.calB = calB;
	}
	public void setRealR(Double[] realR) {
		this.realR = realR;
	}
	public void setRealG(Double[] realG) {
		this.realG = realG;
	}
	public void setRealB(Double[] realB) {
		this.realB = realB;
	}
	public void setCalLStar(Double[] calLStar) {
		this.calLStar = calLStar;
	}
	public void setCalAStar(Double[] calAStar) {
		this.calAStar = calAStar;
	}
	public void setCalBStar(Double[] calBStar) {
		this.calBStar = calBStar;
	}
	public void setRealLStar(Double[] realLStar) {
		this.realLStar = realLStar;
	}
	public void setRealAStar(Double[] realAStar) {
		this.realAStar = realAStar;
	}
	public void setRealBStar(Double[] realBStar) {
		this.realBStar = realBStar;
	}
	public void setX(Double[] x) {
		this.x = x;
	}
	public void setY(Double[] y) {
		this.y = y;
	}
	public void setZ(Double[] z) {
		this.z = z;
	}
	public void setVarX(Double[] varX) {
		this.varX = varX;
	}
	public void setVarY(Double[] varY) {
		this.varY = varY;
	}
	public void setVarZ(Double[] varZ) {
		this.varZ = varZ;
	}
	public void setXYZToRGB(Double[][] xyzToRGB) {
		this.xyzToRGB = xyzToRGB;
	}
	public void setSpecToXYZ(Double[][] specToXYZ) {
		this.specToXYZ = specToXYZ;
	}
	public void setNumRuns(int numRuns) {
		this.numRuns = numRuns;
	}
	public void setAddStep(Double addStep) {
		this.addStep = addStep;
	}
	public void setMultStep(Double multStep) {
		this.multStep = multStep;
	}
	public void setExpStep(Double expStep) {
		this.expStep = expStep;
	}
	
	//Methods
	
	//XYZ calculations
	public Double[] calculateX(Double[][] specData, Double[] specToX) {
		//create local vars for calculations
		
		//set x var to same length as the number of samples
		Double[] x = new Double[specData.length];
		Double temp = 0.0;
		
		//for every sample in passed in data set calculate x 
		for(int i = 0; i < specData.length; i++) {
			temp = 0.0;
			for(int j = 0; j < specToX.length; j++) {
				//multiply every spectrum for sample i by the appropriate conversion value and sum the results
				temp += specData[i][j] * specToX[j];
			}
			x[i] = temp;
		}
		return x;
	}
	
	public Double[] calculateY(Double[][] specData, Double[] specToY) {
		//create local vars for calculations
		
		//set y var to same length as the number of samples
		Double[] y = new Double[specData.length];
		Double temp = 0.0;
		
		//for every sample passed in data set calculate y
		for(int i = 0; i < specData.length; i++) {
			temp = 0.0;
			for(int j = 0; j < specToY.length; j++) {
				//multiply every spectrum for sample i by the appropriate conversion value and sum the results
				temp += specData[i][j] * specToY[j];
			}
			y[i] = temp;
		}
		return y;
	}

	public Double[] calculateZ(Double[][] specData, Double[] specToZ) {
		//create local vars for calculations
		
		//set z var to same length as the number of samples
		Double[] z = new Double[specData.length];
		Double temp = 0.0;
		
		//for every sample passed in data set calculate z
		for(int i = 0; i < specData.length; i++) {
			temp = 0.0;
			for(int j = 0; j < specToZ.length; j++) {
				//multiply every spectrum for sample i by the appropriate conversion value and sum the results
				temp += specData[i][j] * specToZ[j];
			}
			z[i] = temp;
		}
		return z;
	}
	
	//VARXYZ calculations
	public Double[] calculateVarX(Double[] x) {
		//create local vars for calculations
		
		//set varx to same length as x var
		Double[] varX = new Double[x.length];
		
		//create constants for calculations
		Double t = (double) 0.3333333333333333;
		Double s = (double) 0.1379310345;
		
		//for every x value calculate varx
		for(int i = 0; i < x.length; i++) {
			//if x / 4.3 is greater than 0.008856 use this equation
			if((x[i] / 4.3) > 0.008856) {
				varX[i] = Math.pow((x[i] / 4.3), t);
			}
			//else use this equation
			else {
				varX[i] = (((x[i] / 4.3) * 7.787) + s);
			}
		}
		
		return varX;
	}
	
	public Double[] calculateVarY(Double[] y) {
		//create local vars for calculations
		
		//set vary to same length as y var
		Double[] varY = new Double[y.length];
		
		//create constants for calculations
		Double t = (double) (0.3333333333333333);
		Double s = (double) 0.1379310345;

		//for every y value calculate vary
		for(int i = 0; i < y.length; i++) {
			//if y / 4.3 is greater than 0.008856 use this equation
			if((y[i] / 4.3) > 0.008856) {
				varY[i] = Math.pow((y[i] / 4.3), t);
			}
			//else use this equation
			else {
				varY[i] = (((y[i] / 4.3) * 7.787) + s);
				
			}
		}
		
		return varY;
	}
	
	public Double[] calculateVarZ(Double[] z) {
		//create local vars for calculations
		
		//set varz to same length as z var
		Double[] varZ = new Double[z.length];
		
		//create constants for calculations
		Double t = (double) (0.3333333333333333);
		Double s = (double) 0.1379310345;

		//for every z value calculate varz
		for(int i = 0; i < z.length; i++) {
			//if z / 4.0 is greater than 0.008856 use this equation
			if((z[i] / 4) > 0.008856) {
				varZ[i] = Math.pow((z[i] / 4.0), t);
			}
			//else use this equation
			else {
				varZ[i] = (((z[i] / 4) * 7.787) + s);
			}
		}
		
		return varZ;
	}
	
	//CIELAB calculations
	public Double[] calculateLStar(Double[] varY) {
		//create local variable to store result, set length equal to number of samples
		Double[] lStar = new Double[varY.length];
		
		//for every value i use below equation, store in lStar array
		for(int i = 0; i < varY.length; i++) {
			lStar[i] = ((116 * varY[i]) - 16);
		}
		return lStar;
	}
	
	public Double[] calculateAStar(Double[] varX, Double[] varY) {
		//create local variable to store result, set length equal to number of samples
		Double[] aStar = new Double[varY.length];
		
		//for every value i use below equation, store in aStar array
		for(int i = 0; i < varY.length; i++) {
			aStar[i] = (500 * (varX[i] - varY[i]));
		}
		return aStar;
	}
	
	public Double[] calculateBStar(Double[] varY, Double[] varZ) {
		//create local variable to store result, set length equal to number of samples
		Double[] bStar = new Double[varY.length];
		
		//for every value i use below equation, store in bStar array
		for(int i = 0; i < varY.length; i++) {
			bStar[i] = (200 * (varY[i] - varZ[i]));
		}
		return bStar;
	}
	
	//RGB calculations
	public Double[] calculateR(Double[][] xyzToRGB, Double[] x, Double[] y, Double[] z) {
		//create local var to contain the result, set length equal to the number of samples
		Double[] r = new Double[x.length];
		
		//for every value i use below equations
		for(int i = 0; i < x.length; i++) {
			r[i] = ((x[i] / 4.3) * xyzToRGB[0][0]) + ((y[i] / 4.3) * xyzToRGB[0][1]) + ((z[i] / 4) * xyzToRGB[0][2]);
			
			//if the above result is less than 0.0031308 use below equation
			if (r[i] < 0.0031308) {
			      r[i] = (r[i] * 12.92);
			}
			//else use below equation
			else {
				r[i] = (1.055 * Math.pow(r[i],((1.0/2.4)-0.055)));
			}
		}
		return r;
	}
	
	public Double[] calculateG(Double[][] xyzToRGB, Double[] x, Double[] y, Double[] z) {
		//create local var to contain the result, set length equal to the number of samples
		Double[] g = new Double[x.length];
		
		//for every value i use below equations
		for(int i = 0; i < x.length; i++) {
			g[i] = ((x[i] / 4.3) * xyzToRGB[1][0]) + ((y[i] / 4.3) * xyzToRGB[1][1]) + ((z[i] / 4) * xyzToRGB[1][2]);
			
			//if the above result is less than 0.0031308 use below equation
			if (g[i] < 0.0031308) {
			      g[i] = (g[i] * 12.92);
			}
			//else use below equation
			else {
				g[i] = (1.055 * Math.pow(g[i],((1.0/2.4)-0.055)));
			}
		}
		return g;
	}
	
	public Double[] calculateB(Double[][] xyzToRGB, Double[] x, Double[] y, Double[] z) {
		//create local var to contain the result, set length equal to the number of samples
		Double[] b = new Double[x.length];
		
		//for every value i use the below equations
		for(int i = 0; i < x.length; i++) {
			b[i] = ((x[i] / 4.3) * xyzToRGB[2][0]) + ((y[i] / 4.3) * xyzToRGB[2][1]) + ((z[i] / 4) * xyzToRGB[2][2]);
			
			//if the above result is less than 0.0031308 use the below equation
			if (b[i] < 0.0031308) {
			      b[i] = (b[i] * 12.92);
			}
			//else use below equation
			else {
				b[i] = (1.055 * Math.pow(b[i],((1.0/2.4)-0.055)));
			}
		}
		return b;
	}
	
	public Double[] calculateMaxRGB(Double[] maxRGB, Double[] r, Double[] g, Double[] b) {
		//for every RGB value compare to the max RGB value, if it is greater set max RGB to that value 
		for(int i = 0; i < maxRGB.length; i++) {
			if(r[i] >= maxRGB[i]) {
				maxRGB[i] = r[i];
			}
			if(g[i] >= maxRGB[i]) {
				maxRGB[i] = g[i];
			}
			if(b[i] >= maxRGB[i]) {
				maxRGB[i] = b[i];
			}
		}
		
		return maxRGB;
	}
	
	public Double[] scaleRGB(Double[] maxRGB, Double[] rgb) {
		//for every R G or B value, use below equations
		for(int i = 0; i < rgb.length; i++) {
			//if the value is below 0 set to zero
			if(rgb[i] <= 0.0) {
				rgb[i] = 0.0;
			}
			//if it is greater than 1 scale using max RGB
			else if (maxRGB[i] > 1) {
				rgb[i] = 255 * (rgb[i] / maxRGB[i]);
			} 
			//else scale using just 255
			else {
				rgb[i] = 255 * rgb[i]; 
			}
		}
		return rgb;
	}
	
	public Double[][] calculateDeltaRGB(Double[] calR, Double[] calG, Double[] calB,
			Double[] realR, Double[] realG, Double[] realB){
		//create local var to contain result
		Double[][] deltaRGB = new Double[calR.length][3];
		
		//for every RGB value set delta RGB to the difference of the calculated and real vals
		for(int i = 0; i < deltaRGB.length; i++) {
			deltaRGB[i][0] = calR[i] - realR[i];
			deltaRGB[i][1] = calG[i] - realG[i];
			deltaRGB[i][2] = calB[i] - realB[i];
		}
		
		return deltaRGB;
	}
	
	//Delta E calculations
	public Double[] calculateDeltaE(Double[] calLStar, Double[] calAStar, Double[] calBStar,
			Double[] realLStar, Double[] realAStar, Double[] realBStar) {
		//create local var to contain result
		Double[] deltaE = new Double[calLStar.length];
		
		//for every CIELAB value use the below equation 
		for(int i = 0; i < calLStar.length; i++) {
			deltaE[i] = Math.sqrt(Math.pow((calLStar[i] - realLStar[i]), 2) + 
					Math.pow((calAStar[i] - realAStar[i]), 2) + Math.pow((calBStar[i] - 
							realBStar[i]), 2));
		}
		
		return deltaE;
	}
	
	public Double averageDeltaE(Double[] deltaE) {
		//create local var for results
		Double avg = 0.0;
		
		//sum all delta E vals
		for(int i = 0; i < deltaE.length; i++) {
			avg += deltaE[i];
		}
		
		//divide by the number of vals
		avg /= deltaE.length;
		
		return avg;
	}
	
	//Offset methods/calculations
	public Double[][] applyOffsets(Double[][] rawData, Double[] addOffset, Double[] multOffset, 
		Double[] expOffset){
		//create local var for results
		Double[][] offsetData = new Double[rawData.length][rawData[0].length];
		
		//for every data point use below equations to apply offsets
		for(int i = 0; i < rawData.length; i++) {
			for(int j = 0; j < rawData[i].length; j++) {
				
				//if the data with the add and mult offsets applied is greater than 0 use below equation
				if((rawData[i][j] + addOffset[j]) * multOffset[j] > 0) {
					offsetData[i][j] = Math.pow(((rawData[i][j] + addOffset[j]) * 
							multOffset[j]), expOffset[j]);
				}
				//else set to 0
				else {
					offsetData[i][j] = 0.0;
				}
			}
		}
		
		return offsetData;
	}
	
	public Double[] adjustAddOffsets(Double[] addOffset, Double[] multOffset, 
			Double[] expOffset, Double avgDeltaE, Double[][] rawData, Double addStep, 
			Double[][] specToXYZ, Double[] realLStar, Double[] realAStar, Double[] realBStar) {
		//Set up local vars for calculations and results
		Double[] tempAddOffset = addOffset;
		Double[][] tempData = new Double[rawData.length][rawData[0].length];
		Double tempAvgDeltaE = 0.0;
		Double[] x = new Double[rawData.length];
		Double[] y = new Double[rawData.length];
		Double[] z = new Double[rawData.length];
		Double[] varX = new Double[rawData.length];
		Double[] varY = new Double[rawData.length];
		Double[] varZ = new Double[rawData.length];
		Double[] calLStar = new Double[rawData.length];
		Double[] calAStar = new Double[rawData.length];
		Double[] calBStar = new Double[rawData.length];
		
		//for every offset value, iterate through positive loop
		for(int i = addOffset.length - 1; i > 0; i--) {
			//print the offset number to check progress
			Boolean k = true;
			
			//while the iteration improves the delta e continue, stop when it gets worse or the change is too small
			while(k) {
				//apply step
				tempAddOffset[i] += addStep;
				
				//apply offset
				tempData = applyOffsets(rawData, tempAddOffset, multOffset, expOffset);
				
				//calculate XYZ
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				
				//calculate VARXYZ
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				
				//calculate CIELAB
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				
				//calculate delta e and average it
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				//If delta e got worse, stayed the same, or the change is too small, exit loop
				if((tempAvgDeltaE >= avgDeltaE) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
					//reverse step
					addOffset[i] = tempAddOffset[i] - addStep;
					k = false;
					
				}
				//Otherwise continue process
				else {
					addOffset[i] = tempAddOffset[i];
					avgDeltaE = tempAvgDeltaE;
				}
			}
		}
		
		//switch step to negative
		addStep = -addStep;
		
		//for every offset value, iterate through negative loop
		for(int i = addOffset.length - 1; i > 0; i--) {
			//print the offset number to check progress
			Boolean l = true;
			
			//while the iteration improves the delta e continue, stop when it gets worse or the change is too small
			while(l) {
				//apply step
				tempAddOffset[i] += addStep;
				
				//apply offset
				tempData = applyOffsets(rawData, tempAddOffset, multOffset, expOffset);
				
				//calculate XYZ
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				
				//calculate VARXYZ
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				
				//calculate CIELAB
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				
				//calculate delta e and average it
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				//If delta e got worse, stayed the same, or the change is too small, exit loop
				if((tempAvgDeltaE >= avgDeltaE) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
					//reverse step
					addOffset[i] = tempAddOffset[i] - addStep;
					l = false;
					
				}
				//Otherwise continue process
				else {
					addOffset[i] = tempAddOffset[i];
					avgDeltaE = tempAvgDeltaE;
				}
			}
		}
		return addOffset;
	}

	public Double[] adjustMultOffsets(Double[] addOffset, Double[] multOffset, 
			Double[] expOffset, Double avgDeltaE, Double[][] rawData, Double multStep, 
			Double[][] specToXYZ, Double[] realLStar, Double[] realAStar, Double[] realBStar) {
		//Set up local vars for calculations and results
		Double[] tempMultOffset = multOffset;
		Double[][] tempData = new Double[rawData.length][rawData[0].length];
		Double tempAvgDeltaE = 0.0;
		Double[] x = new Double[rawData.length];
		Double[] y = new Double[rawData.length];
		Double[] z = new Double[rawData.length];
		Double[] varX = new Double[rawData.length];
		Double[] varY = new Double[rawData.length];
		Double[] varZ = new Double[rawData.length];
		Double[] calLStar = new Double[rawData.length];
		Double[] calAStar = new Double[rawData.length];
		Double[] calBStar = new Double[rawData.length];
		
		//for every offset value, iterate through positive loop
		for(int i = multOffset.length - 1; i > 0; i--) {
			//print the offset number to check progress
			Boolean k = true;
			
			//while the iteration improves the delta e continue, stop when it gets worse or the change is too small
			while(k) {
				//apply step
				tempMultOffset[i] += multStep;
				
				//apply offsets
				tempData = applyOffsets(rawData, addOffset, tempMultOffset, expOffset);
				
				//calculate XYZ
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				
				//calculate VARXYZ
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				
				//calculate CIELAB
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				
				//calculate delta E and average it
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				//If delta e got worse, stayed the same, went below 0.0001, or the change is too small, exit loop
				if((tempAvgDeltaE >= avgDeltaE) || (tempMultOffset[i] <= 0.0001) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
					//reverse step
					multOffset[i] = tempMultOffset[i] - multStep;
					k = false;
					
				}
				//Otherwise continue process
				else {
					multOffset[i] = tempMultOffset[i];
					avgDeltaE = tempAvgDeltaE;
				}
			}
		}
		
		//switch step to negative
		multStep = -multStep;
		
		//for every offset value, iterate through negative loop
		for(int i = multOffset.length - 1; i > 0; i--) {
			//print the offset number to check progress
			Boolean l = true;
			
			//while the iteration improves the delta e continue, stop when it gets worse or the change is too small
			while(l) {
				//apply step
				tempMultOffset[i] += multStep;
				
				//apply offsets
				tempData = applyOffsets(rawData, addOffset, tempMultOffset, expOffset);
				
				//calculate XYZ
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				
				//calculate VARXYZ
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				
				//calculate CIELAB
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				
				//calculate delta E and average it
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				//If delta e got worse, stayed the same, went below 0.0001, or the change is too small, exit loop
				if((tempAvgDeltaE >= avgDeltaE) || (tempMultOffset[i] <= 0.0001) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
					//reverse step
					multOffset[i] = tempMultOffset[i] - multStep;
					l = false;
					
				}
				//Otherwise continue process
				else {
					multOffset[i] = tempMultOffset[i];
					avgDeltaE = tempAvgDeltaE;
				}
			}
		}
		return multOffset;
	}

	public Double[] adjustExpOffsets(Double[] addOffset, Double[] multOffset, 
			Double[] expOffset, Double avgDeltaE, Double[][] rawData, Double expStep, 
			Double[][] specToXYZ, Double[] realLStar, Double[] realAStar, Double[] realBStar) {
		//Set up local vars for calculations and results
		Double[] tempExpOffset = expOffset;
		Double[][] tempData = new Double[rawData.length][rawData[0].length];
		Double tempAvgDeltaE = 0.0;
		Double[] x = new Double[rawData.length];
		Double[] y = new Double[rawData.length];
		Double[] z = new Double[rawData.length];
		Double[] varX = new Double[rawData.length];
		Double[] varY = new Double[rawData.length];
		Double[] varZ = new Double[rawData.length];
		Double[] calLStar = new Double[rawData.length];
		Double[] calAStar = new Double[rawData.length];
		Double[] calBStar = new Double[rawData.length];
		
		//for every offset value, iterate through positive loop
		for(int i = expOffset.length - 1; i > 0; i--) {
			//print the offset number to check progress
			Boolean k = true;
			
			//while the iteration improves the delta e continue, stop when it gets worse or the change is too small
			while(k) {
				//apply step
				tempExpOffset[i] += expStep;
				
				//apply offsets
				tempData = applyOffsets(rawData, addOffset, multOffset, tempExpOffset);
				
				//calculate XYZ
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				
				//calculate VARXYZ
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				
				//calculate CIELAB
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				
				//calculate delta E and average it
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				//If delta e got worse, stayed the same, went below 0.01, or the change is too small, exit loop
				if((tempAvgDeltaE >= avgDeltaE) || (tempExpOffset[i] <= 0.01) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
					//reverse step
					expOffset[i] = tempExpOffset[i] - expStep;
					k = false;
					
				}
				//Otherwise continue process
				else {
					expOffset[i] = tempExpOffset[i];
					avgDeltaE = tempAvgDeltaE;
				}
			}
		}
		
		//switch step to negative
		expStep = -expStep;
		
		//for every offset value, iterate through negative loop
		for(int i = expOffset.length - 1; i > 0; i--) {
			//print the offset number to check progress
			Boolean l = true;
			
			//while the iteration improves the delta e continue, stop when it gets worse or the change is too small
			while(l) {
				//apply step
				tempExpOffset[i] += expStep;
				
				//apply offsets
				tempData = applyOffsets(rawData, addOffset, multOffset, tempExpOffset);
				
				//calculate XYZ
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				
				//calculate VARXYZ
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				
				//calculate CIELAB
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				
				//calculate delta E and average it
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				//If delta e got worse, stayed the same, went below 0.01, or the change is too small, exit loop
				if((tempAvgDeltaE >= avgDeltaE) || (tempExpOffset[i] <= 0.01) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
					//reverse the step
					expOffset[i] = tempExpOffset[i] - expStep;
					l = false;
					
				}
				//Otherwise continue process
				else {
					expOffset[i] = tempExpOffset[i];
					avgDeltaE = tempAvgDeltaE;
				}
			}
		}
		return expOffset;
	}
	
	//conversion methods, needed for JUnit testing as Double isnt the same as double
	public double[] convertDTod1D (Double[] arr) {
		//create a local var to store the results
		double[] temp = new double[arr.length];
		
		//for every val, cast as double
		for(int i = 0; i < arr.length; i++) {
			temp[i] = (double)arr[i];
		}
		
		return temp;
	}
	
	public double[][] convertDTod2D (Double[][] arr) {
		//create a local var to store the results
		double[][] temp = new double[arr.length][arr[0].length];
		
		//for every val, cast as double
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				temp[i][j] = (double)arr[i][j];
			}
			
		}
		
		return temp;
	}

}
