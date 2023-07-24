import java.util.ArrayList;
import java.util.List;

class Vertex {
String name;
List<Vertex> adjacentVertices;
boolean colored;
String color;

public Vertex(String name) {
this.name = name;
this.adjacentVertices = new ArrayList<>();
this.colored =false;
this.color = "";
}

//connect two verticess bi-directional
public void addNeighbor(Vertex vertex){
this.adjacentVertices.add(vertex);
vertex.adjacentVertices.add(this);
}
}

class Coloring {
String colors[];
int colorCount;
int numberOfVertices;

public Coloring(String[] colors, int N) {
this.colors = colors;
this.numberOfVertices = N;
}

public boolean setColors(Vertex vertex){
//Step: 1
for(int colorIndex=0; colorIndex<colors.length; colorIndex++){
//Step-1.1: checking validity
if(!canColorWith(colorIndex, vertex))
continue;

//Step-1.2: continue coloring
vertex.color=colors[colorIndex];
vertex.colored=true;
colorCount++;
//Step-1.3: check whether all vertices colored?
if(colorCount== numberOfVertices) //base case
return true;

//Step-1.4: next uncolored vertex
for(Vertex nbrvertex: vertex.adjacentVertices){
if (!nbrvertex.colored){
if(setColors(nbrvertex))
return true;
}
}

}

//Step-4: backtrack
vertex.colored = false;
vertex.color = "";
return false;
}

//Function to check whether it is valid to color with color[colorIndex]
boolean canColorWith(int colorIndex, Vertex vertex) {
for(Vertex nbrvertex: vertex.adjacentVertices){
if(nbrvertex.colored && nbrvertex.color.equals(colors[colorIndex]))
return false;
}
return true;
}

}

public class GraphC{
public static void main(String args[]){
//define vertices
Vertex vertices[]= {new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D")};

//join verices
vertices[0].addNeighbor(vertices[1]);
vertices[1].addNeighbor(vertices[2]);
vertices[2].addNeighbor(vertices[3]);
vertices[0].addNeighbor(vertices[3]);

//define colors
String colors[] = {"Green","Blue"};

//create coloring object
Coloring coloring = new Coloring(colors, vertices.length);

//start coloring with vertex-A
boolean hasSolution = coloring.setColors(vertices[0]);

//check if coloring was successful
if (!hasSolution)
System.out.println("No Solution");
else {
for (Vertex vertex: vertices){
System.out.println(vertex.name + " "+ vertex.color +"\n");
}

}
}
}