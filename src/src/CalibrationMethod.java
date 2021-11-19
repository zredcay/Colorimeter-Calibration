package src;

public class CalibrationMethod {
	//Variables
	private Double[][] rawData;
	private Double[][] altData;
	private Double[] addOffset;
	private Double[] multOffset;
	private Double[] expOffset;
	private Double[] deltaE;
	private Double avgDeltaE;
	private Double[] maxRGB;
	private Double[] calR;
	private Double[] calG;
	private Double[] calB;
	private Double[] realR;
	private Double[] realG;
	private Double[] realB;
	private Double[] calLStar;
	private Double[] calAStar;
	private Double[] calBStar;
	private Double[] realLStar;
	private Double[] realAStar;
	private Double[] realBStar;
	private Double[] x;
	private Double[] y;
	private Double[] z;
	private Double[] varX;
	private Double[] varY;
	private Double[] varZ;
	private Double[][] xyzToRGB;
	private Double[][] specToXYZ;
	private int numRuns;
	private Double addStep;
	private Double multStep;
	private Double expStep;
	
	//Constructor
	public CalibrationMethod(Double[][] rawData, Double[][] altData, Double[] addOffset,
			Double[] multOffset, Double[] expOffset, Double[] deltaE, Double avgDeltaE, Double[] maxRGB, Double[] calR, Double[] calG, Double[] calB,
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
	public Double[] calculateX(Double[][] specData, Double[] specToX) {
		Double[] x = new Double[specData.length];
		Double temp = 0.0;
		
		for(int i = 0; i < specData.length; i++) {
			temp = 0.0;
			for(int j = 0; j < specToX.length; j++) {
				temp += specData[i][j] * specToX[j];
			}
			x[i] = temp;
		}
		return x;
	}
	
	public Double[] calculateY(Double[][] specData, Double[] specToY) {
		Double[] y = new Double[specData.length];
		Double temp = 0.0;
		
		for(int i = 0; i < specData.length; i++) {
			temp = 0.0;
			for(int j = 0; j < specToY.length; j++) {
				temp += specData[i][j] * specToY[j];
			}
			y[i] = temp;
		}
		return y;
	}

	public Double[] calculateZ(Double[][] specData, Double[] specToZ) {
		Double[] z = new Double[specData.length];
		Double temp = 0.0;
		
		for(int i = 0; i < specData.length; i++) {
			temp = 0.0;
			for(int j = 0; j < specToZ.length; j++) {
				temp += specData[i][j] * specToZ[j];
			}
			z[i] = temp;
		}
		return z;
	}
	
	public Double[] calculateVarX(Double[] x) {
		Double[] varX = new Double[x.length];
		Double t = (double) 0.3333333333333333;
		Double s = (double) 0.1379310345;
		
		for(int i = 0; i < x.length; i++) {
			if((x[i] / 4.3) > 0.008856) {
				varX[i] = Math.pow((x[i] / 4.3), t);
			}
			else {
				varX[i] = (((x[i] / 4.3) * 7.787) + s);
			}
		}
		
		return varX;
	}
	
	public Double[] calculateVarY(Double[] y) {
		Double[] varY = new Double[y.length];
		Double t = (double) (0.3333333333333333);
		Double s = (double) 0.1379310345;

		for(int i = 0; i < y.length; i++) {
			if((y[i] / 4.3) > 0.008856) {
				varY[i] = Math.pow((y[i] / 4.3), t);
			}
			else {
				varY[i] = (((y[i] / 4.3) * 7.787) + s);
				
			}
		}
		
		return varY;
	}
	
	public Double[] calculateVarZ(Double[] z) {
		Double[] varZ = new Double[z.length];
		Double t = (double) (0.3333333333333333);
		Double s = (double) 0.1379310345;

		for(int i = 0; i < z.length; i++) {
			if((z[i] / 4) > 0.008856) {
				varZ[i] = Math.pow((z[i] / 4.0), t);
			}
			else {
				varZ[i] = (((z[i] / 4) * 7.787) + s);
			}
		}
		
		return varZ;
	}
	
	public Double[] calculateLStar(Double[] varY) {
		Double[] lStar = new Double[varY.length];
		
		for(int i = 0; i < varY.length; i++) {
			lStar[i] = ((116 * varY[i]) - 16);
		}
		return lStar;
	}
	
	public Double[] calculateAStar(Double[] varX, Double[] varY) {
		Double[] aStar = new Double[varY.length];
		
		for(int i = 0; i < varY.length; i++) {
			aStar[i] = (500 * (varX[i] - varY[i]));
		}
		return aStar;
	}
	
	public Double[] calculateBStar(Double[] varY, Double[] varZ) {
		Double[] bStar = new Double[varY.length];
		
		for(int i = 0; i < varY.length; i++) {
			bStar[i] = (200 * (varY[i] - varZ[i]));
		}
		return bStar;
	}
	
	public Double[] calculateR(Double[][] xyzToRGB, Double[] x, Double[] y, Double[] z) {
		Double[] r = new Double[x.length];
		for(int i = 0; i < x.length; i++) {
			r[i] = ((x[i] / 4.3) * xyzToRGB[0][0]) + ((y[i] / 4.3) * xyzToRGB[0][1]) + ((z[i] / 4) * xyzToRGB[0][2]);
			if (r[i] < 0.0031308) {
			      r[i] = (r[i] * 12.92);
			    } 
			else {
				r[i] = (1.055 * Math.pow(r[i],((1.0/2.4)-0.055)));
			}
		}
		return r;
	}
	
	public Double[] calculateG(Double[][] xyzToRGB, Double[] x, Double[] y, Double[] z) {
		Double[] g = new Double[x.length];
		
		for(int i = 0; i < x.length; i++) {
			g[i] = ((x[i] / 4.3) * xyzToRGB[1][0]) + ((y[i] / 4.3) * xyzToRGB[1][1]) + ((z[i] / 4) * xyzToRGB[1][2]);
			if (g[i] < 0.0031308) {
			      g[i] = (g[i] * 12.92);
			    } 
			else {
				g[i] = (1.055 * Math.pow(g[i],((1.0/2.4)-0.055)));
			}
		}
		return g;
	}
	
	public Double[] calculateB(Double[][] xyzToRGB, Double[] x, Double[] y, Double[] z) {
		Double[] b = new Double[x.length];
		
		for(int i = 0; i < x.length; i++) {
			b[i] = ((x[i] / 4.3) * xyzToRGB[2][0]) + ((y[i] / 4.3) * xyzToRGB[2][1]) + ((z[i] / 4) * xyzToRGB[2][2]);
			if (b[i] < 0.0031308) {
			      b[i] = (b[i] * 12.92);
			    } 
			else {
				b[i] = (1.055 * Math.pow(b[i],((1.0/2.4)-0.055)));
			}
		}
		return b;
	}
	
	public Double[] calculateMaxRGB(Double[] maxRGB, Double[] r, Double[] g, Double[] b) {
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
		for(int i = 0; i < rgb.length; i++) {
			if(rgb[i] <= 0.0) {
				rgb[i] = 0.0;
			}
			else if (maxRGB[i] > 1) {
				rgb[i] = 255 * (rgb[i] / maxRGB[i]);
			} 
			else {
				rgb[i] = 255 * rgb[i]; 
			}
		}
		return rgb;
	}
	
	public Double[] calculateDeltaE(Double[] calLStar, Double[] calAStar, Double[] calBStar,
			Double[] realLStar, Double[] realAStar, Double[] realBStar) {
		Double[] deltaE = new Double[calLStar.length];
		
		for(int i = 0; i < calLStar.length; i++) {
			deltaE[i] = Math.sqrt(Math.pow((calLStar[i] - realLStar[i]), 2) + 
					Math.pow((calAStar[i] - realAStar[i]), 2) + Math.pow((calBStar[i] - 
							realBStar[i]), 2));
		}
		
		return deltaE;
	}
	
	public Double averageDeltaE(Double[] deltaE) {
		Double avg = 0.0;
		for(int i = 0; i < deltaE.length; i++) {
			avg += deltaE[i];
		}
		avg /= deltaE.length;
		return avg;
	}
	
	public Double[][] applyOffsets(Double[][] rawData, Double[] addOffset, Double[] multOffset, 
		Double[] expOffset){
		Double[][] offsetData = new Double[rawData.length][rawData[0].length];
		
		for(int i = 0; i < rawData.length; i++) {
			for(int j = 0; j < rawData[i].length; j++) {
				if((rawData[i][j] + addOffset[j]) * multOffset[j] > 0) {
					offsetData[i][j] = Math.pow(((rawData[i][j] + addOffset[j]) * 
							multOffset[j]), expOffset[j]);
				}
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
		//Set up vars
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
		
		for(int i = addOffset.length - 1; i > 0; i--) {
			System.out.println("Offset " + i);
			Boolean k = true;
			while(k) {
				//Apply step and calculate avg delta e
				tempAddOffset[i] += addStep;
				tempData = applyOffsets(rawData, tempAddOffset, multOffset, expOffset);
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				/*System.out.println("Offset: " + tempAddOffset[i]);
				System.out.println("Temp Avg Delta E: " + tempAvgDeltaE);
				System.out.println("Avg Delta E:      " + avgDeltaE);
				System.out.println("Difference: " + (avgDeltaE - tempAvgDeltaE));*/
				
				//If delta e got worse or stayed the same, try other direction
				if((tempAvgDeltaE >= avgDeltaE) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
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
		
		addStep = -addStep;
		
		for(int i = addOffset.length - 1; i > 0; i--) {
			Boolean l = true;
			while(l) {
				//Apply step and calculate avg delta e
				tempAddOffset[i] += addStep;
				tempData = applyOffsets(rawData, tempAddOffset, multOffset, expOffset);
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				/*System.out.println("Offset: " + tempAddOffset[i]);
				System.out.println("Temp Avg Delta E: " + tempAvgDeltaE);
				System.out.println("Avg Delta E:      " + avgDeltaE);
				System.out.println("Difference: " + (avgDeltaE - tempAvgDeltaE));*/
				
				//If delta e got worse or stayed the same, try other direction
				if((tempAvgDeltaE >= avgDeltaE) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
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
		//Set up vars
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
		
		for(int i = multOffset.length - 1; i > 0; i--) {
			System.out.println("Offset " + i);
			Boolean k = true;
			while(k) {
				//Apply step and calculate avg delta e
				tempMultOffset[i] += multStep;
				tempData = applyOffsets(rawData, addOffset, tempMultOffset, expOffset);
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				/*System.out.println("Offset: " + tempMultOffset[i]);
				System.out.println("Temp Avg Delta E: " + tempAvgDeltaE);
				System.out.println("Avg Delta E:      " + avgDeltaE);
				System.out.println("Difference: " + (avgDeltaE - tempAvgDeltaE));*/
				
				//If delta e got worse or stayed the same, try other direction
				if((tempAvgDeltaE >= avgDeltaE) || (tempMultOffset[i] <= 0.0001) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
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
		
		multStep = -multStep;
		
		for(int i = multOffset.length - 1; i > 0; i--) {
			Boolean l = true;
			while(l) {
				//Apply step and calculate avg delta e
				tempMultOffset[i] += multStep;
				tempData = applyOffsets(rawData, addOffset, tempMultOffset, expOffset);
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				/*System.out.println("Offset: " + tempMultOffset[i]);
				System.out.println("Temp Avg Delta E: " + tempAvgDeltaE);
				System.out.println("Avg Delta E:      " + avgDeltaE);
				System.out.println("Difference: " + (avgDeltaE - tempAvgDeltaE));*/
				
				//If delta e got worse or stayed the same, try other direction
				if((tempAvgDeltaE >= avgDeltaE) || (tempMultOffset[i] <= 0.0001) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
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
		//Set up vars
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
		
		for(int i = expOffset.length - 1; i > 0; i--) {
			System.out.println("Offset " + i);
			Boolean k = true;
			while(k) {
				//Apply step and calculate avg delta e
				tempExpOffset[i] += expStep;
				tempData = applyOffsets(rawData, addOffset, multOffset, tempExpOffset);
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				/*System.out.println("Offset: " + tempExpOffset[i]);
				System.out.println("Temp Avg Delta E: " + tempAvgDeltaE);
				System.out.println("Avg Delta E:      " + avgDeltaE);
				System.out.println("Difference: " + (avgDeltaE - tempAvgDeltaE));*/
				
				//If delta e got worse or stayed the same, try other direction
				if((tempAvgDeltaE >= avgDeltaE) || (tempExpOffset[i] <= 0.01) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
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
		
		expStep = -expStep;
		
		for(int i = expOffset.length - 1; i > 0; i--) {
			Boolean l = true;
			while(l) {
				//Apply step and calculate avg delta e
				tempExpOffset[i] += expStep;
				tempData = applyOffsets(rawData, addOffset, multOffset, tempExpOffset);
				x = calculateX(tempData, specToXYZ[0]);
				y = calculateY(tempData, specToXYZ[1]);
				z = calculateZ(tempData, specToXYZ[2]);
				varX = calculateVarX(x);
				varY = calculateVarY(y);
				varZ = calculateVarZ(z);
				calLStar = calculateLStar(varY);
				calAStar = calculateAStar(varX, varY);
				calBStar = calculateBStar(varY, varZ);
				tempAvgDeltaE = averageDeltaE(calculateDeltaE(calLStar, calAStar, 
						calBStar, realLStar, realAStar, realBStar));
				
				/*System.out.println("Offset: " + tempExpOffset[i]);
				System.out.println("Temp Avg Delta E: " + tempAvgDeltaE);
				System.out.println("Avg Delta E:      " + avgDeltaE);
				System.out.println("Difference: " + (avgDeltaE - tempAvgDeltaE));*/
				
				//If delta e got worse or stayed the same, try other direction
				if((tempAvgDeltaE >= avgDeltaE) || (tempExpOffset[i] <= 0.01) || ((avgDeltaE - tempAvgDeltaE) <= 0.00000001)) {
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
		
	public double[] convertDTod1D (Double[] arr) {
		double[] temp = new double[arr.length];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = (double)arr[i];
		}
		
		return temp;
	}
	
	public double[][] convertDTod2D (Double[][] arr) {
		double[][] temp = new double[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				temp[i][j] = (double)arr[i][j];
			}
			
		}
		
		return temp;
	}

}
