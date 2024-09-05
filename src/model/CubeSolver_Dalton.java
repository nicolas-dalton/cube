package model;

import java.awt.Color;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;



public class CubeSolver_Dalton 
{
	// post condition: returns a set of distinct cubes dependent on colors.size()
	// STRAIGHTFORDWARD: getDistinctSolidCubes({RED}) -> {Cube(RED, RED, RED, RED, RED,RED)}
	// EXTREME : getDistinctSolidCubes({}) -> {}
	// BIZZARE : getDistinctSolidCubes({null}) -> NB
	public Set<Cube> getDistinctSolidCubes(Set<Color> colors)
	{
		assert colors != null;
		assert !colors.contains(null);
		ArrayList <Color> colorsList = new ArrayList<>(colors);
		Set <Cube> setOfDistinctCubes = new HashSet<>();
		long timespentinadd = 0;
		if(colors.size() != 0)
		{
			for(int i = 0; i < colorsList.size(); i++)
			{
				for(int j = 0; j < colorsList.size(); j++)
				{
					for(int k = 0; k < colorsList.size(); k++)
					{
						for(int l = 0; l < colorsList.size(); l++)
						{
							for(int m = 0; m < colorsList.size(); m++)
							{
								for(int n = 0; n < colorsList.size(); n++)
								{
									Cube tempCube = new CubeImpl_Dalton(colorsList.get(i), 
											colorsList.get(j), colorsList.get(k),colorsList.get(l),
											colorsList.get(m), colorsList.get(n));
									long startadd = System.currentTimeMillis();
									setOfDistinctCubes.add(tempCube);
									long endadd = System.currentTimeMillis();
									long duration = (endadd- startadd);
									timespentinadd += duration;
								}

							}
						}
					}
				}

			}
		}
		System.out.println("timespentinadd: "+timespentinadd);
		return setOfDistinctCubes;

	}
	// precondtion : CubeNet object
	// postcondition : permutates the top, bottom, left, right, front and back
			// to make new distinct CubeNet objects and put it in a set
	public static Set<CubeNet> findVarationsOfCubeNet(CubeNet myCubeNet)
	{
		ArrayList <Color> oppositeSquares1 = new ArrayList<>(Arrays.asList(myCubeNet.getTop(),myCubeNet.getBottom()));
		ArrayList <Color> oppositeSquares2 = new ArrayList<>(Arrays.asList(myCubeNet.getRight(),myCubeNet.getLeft()));
		ArrayList <Color> oppositeSquares3 = new ArrayList<>(Arrays.asList(myCubeNet.getFront(),myCubeNet.getBack()));
		ArrayList<ArrayList<Color>> cubeNetArray = new ArrayList<>(Arrays.asList(oppositeSquares1, oppositeSquares2, oppositeSquares3));

		Set<CubeNet> setOfCubeNets = permutateSquarePairs(cubeNetArray);

		return setOfCubeNets;
	}
	// pre condition: arraylist of arraylist Color
	// post Condition: permutates the top, bottom, front and back to create distinct CubeNets
	public static Set<CubeNet> rotateTopBottom(ArrayList<ArrayList<Color>> cubeFacesList)
	{
		Set <CubeNet> setOfCubeNets = new HashSet<>();

		ArrayList <Color> oppositeSquares1 = cubeFacesList.get(0);
		ArrayList <Color> oppositeSquares2 = cubeFacesList.get(1);
		ArrayList <Color> oppositeSquares3 = cubeFacesList.get(2);
		//Original CubeFaces List added to setOfCubeNets
		CubeNet possiblityCubeNet1 = new CubeNetImpl_Dalton(oppositeSquares1.get(0),oppositeSquares1.get(1),
				oppositeSquares2.get(0), oppositeSquares2.get(1), oppositeSquares3.get(0),oppositeSquares3.get(1));
		setOfCubeNets.add(possiblityCubeNet1); 
		//Checked
		//Rotated
		CubeNet possiblityCubeNet2 = new CubeNetImpl_Dalton(oppositeSquares3.get(0),oppositeSquares3.get(1),
				oppositeSquares2.get(0), oppositeSquares2.get(1), oppositeSquares1.get(1),oppositeSquares1.get(0));
		setOfCubeNets.add(possiblityCubeNet2);
		//Checked
		//Rotated again...
		CubeNet possiblityCubeNet3 = new CubeNetImpl_Dalton(oppositeSquares1.get(1),oppositeSquares1.get(0),
				oppositeSquares2.get(0), oppositeSquares2.get(1), oppositeSquares3.get(1),oppositeSquares3.get(0));
		setOfCubeNets.add(possiblityCubeNet3);
		//Checked
		//Rotated again...
		CubeNet possiblityCubeNet4 = new CubeNetImpl_Dalton(oppositeSquares3.get(1),oppositeSquares3.get(0),
				oppositeSquares2.get(0), oppositeSquares2.get(1), oppositeSquares1.get(1),oppositeSquares1.get(0));
		setOfCubeNets.add(possiblityCubeNet4);
		//Checked


		return setOfCubeNets;
	}
	// pre condition : arraylist of arraylist Color
	// post condition: returns set of distinct CubeNets
	public static Set<CubeNet> permutateSquarePairs(ArrayList<ArrayList<Color>> arrayName)
	{
		Set<CubeNet> setOfCubeNets = new HashSet<>();
		for(int i = 1; i <=3; i++)
		{
			Set <CubeNet> tempCubeNetSet = rotateTopBottom(arrayName);
			Set <CubeNet> tempCubeNetSet2 = rotateLeftRight(arrayName);
			setOfCubeNets.addAll(tempCubeNetSet);
			setOfCubeNets.addAll(tempCubeNetSet2);
			Collections.swap(arrayName, 0, 2);
			Collections.swap(arrayName, 0, 1);

		}
		return setOfCubeNets;
	}
	// pre condition: arraylist of arraylist Color
	// post Condition: permutates the front, back, left and right to create distinct CubeNets
	public static Set<CubeNet> rotateLeftRight(ArrayList<ArrayList<Color>> cubeFacesList)
	{
		Set <CubeNet> setOfCubeNets = new HashSet<>();

		ArrayList <Color> oppositeSquares1 = cubeFacesList.get(0);
		ArrayList <Color> oppositeSquares2 = cubeFacesList.get(1);
		ArrayList <Color> oppositeSquares3 = cubeFacesList.get(2);
		//Original CubeFaces List added to setOfCubeNets
		CubeNet possiblityCubeNet1 = new CubeNetImpl_Dalton(oppositeSquares1.get(0),oppositeSquares1.get(1),
				oppositeSquares2.get(0), oppositeSquares2.get(1), oppositeSquares3.get(0),oppositeSquares3.get(1));
		setOfCubeNets.add(possiblityCubeNet1); 
		//Rotate...
		CubeNet possiblityCubeNet2 = new CubeNetImpl_Dalton(oppositeSquares1.get(0),oppositeSquares1.get(1),
				oppositeSquares3.get(0), oppositeSquares3.get(1), oppositeSquares2.get(1),oppositeSquares2.get(0));
		setOfCubeNets.add(possiblityCubeNet2);
		//Rotate...
		CubeNet possiblityCubeNet3 = new CubeNetImpl_Dalton(oppositeSquares1.get(0),oppositeSquares1.get(1),
				oppositeSquares2.get(1), oppositeSquares2.get(0), oppositeSquares3.get(1),oppositeSquares3.get(0));
		setOfCubeNets.add(possiblityCubeNet3);
		//Rotate..
		CubeNet possiblityCubeNet4 = new CubeNetImpl_Dalton(oppositeSquares1.get(0),oppositeSquares1.get(1),
				oppositeSquares3.get(1), oppositeSquares3.get(0), oppositeSquares2.get(0),oppositeSquares2.get(1));
		setOfCubeNets.add(possiblityCubeNet4);
		return setOfCubeNets;
	}
}
