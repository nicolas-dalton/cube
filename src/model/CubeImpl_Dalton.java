package model;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
public class CubeImpl_Dalton implements Cube 
{
	
	Color face1;
	Color face2;
	
	Color face3;
	Color face4;
	
	Color face5;
	Color face6;
	int level;
	//Constructor takes in 6 colors
	public CubeImpl_Dalton(Color color1, Color color2,Color color3,Color color4,Color color5, Color color6)
	{
		// Each every two faces are opposite from each other
		face1 = color1;
		face2 = color2;
		// face 1 and face 2 are squares that do not touch each other
		face3 = color3;
		face4 =  color4;
		// face 3 and face 4 are squares that do not touch each other
		face5 = color5; 
		face6 = color6;
		// face 5 and face 6 are squares that do not touch each other
		level = 1;
	}
	//post condition: Returns a CubeNet object
	@Override
	public CubeNet getSnapshot() 
	{
		CubeNet myCubeNet = new CubeNetImpl_Dalton(face1,face2,face3,face4,face5,face6);
		return myCubeNet;
	}
	//HashCode overwrite
	public int hashCode()
	{
		int hash_code = 0;
		if(this.level == 1)
		{
			hash_code = (face1.getRGB() + face2.getRGB()+ face3.getRGB()+
				face4.getRGB()+ face5.getRGB()+ face6.getRGB());
		}
		return hash_code;
	}
	public String toString()
	{
		CubeNet aCubeNet = getSnapshot();
		return aCubeNet.toString();
	}
	@Override
	public boolean equals(Object obj)
	{
		Cube cubeObject = (Cube)(obj);
		CubeNet cubeNetObject = cubeObject.getSnapshot();
		CubeNet myCubeNet = getSnapshot();
		
		Set <CubeNet> set1 = CubeSolver_Dalton.findVarationsOfCubeNet(cubeNetObject);
		Set <CubeNet> set2 = CubeSolver_Dalton.findVarationsOfCubeNet(myCubeNet);
		boolean result = set1.equals(set2);
		return result;
	}
	
}
