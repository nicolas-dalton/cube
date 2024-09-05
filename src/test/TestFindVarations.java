package test;

import java.awt.Color;
import java.util.Set;

import model.CubeNet;
import model.CubeNetImpl_Dalton;
import model.CubeSolver_Dalton;

public class TestFindVarations 
{
	public static void main(String[]args)
	{
		// Test for Every Face having the color Red
		CubeNet redCubeNet = new CubeNetImpl_Dalton(
				Color.RED, Color.RED,Color.RED, Color.RED, Color.RED,Color.RED);
		Set<CubeNet> cubeNetSet = CubeSolver_Dalton.findVarationsOfCubeNet(redCubeNet);
		System.out.println(cubeNetSet.size());
		
		CubeNet sixColorsCubeNet = new CubeNetImpl_Dalton(
				Color.RED, Color.BLUE,Color.ORANGE, Color.YELLOW, Color.GREEN,Color.BLACK);
		Set <CubeNet>  sixColorsCubeNetSet = CubeSolver_Dalton.findVarationsOfCubeNet(sixColorsCubeNet);
		System.out.println(sixColorsCubeNetSet.size());
	}
}
