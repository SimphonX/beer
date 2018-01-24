package beer;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author dvosy
 */
public class Calculator {
    private static final int EARTH_RADIUS = 6371;
    private Mysql sql;
    private LinkedList<Data> list;
    private String pat;
    private double km;
    private int beerTypes;
    private double[][] dist;
    /**
     * Starts program
     */
    public void start()
    {
        Scanner sc = new Scanner(System.in);
        
        sql = new Mysql(sc.nextDouble(), sc.nextDouble());
        sql.connect();
        list = sql.getData();
        processData();
        findPath(0, 0, 0, "0 ");
        display();
    }
    /**
     * creates distance matrix
     */
    public void processData()
    {
        dist = new double[list.toArray().length][list.toArray().length];
        for(int i = 0; i < list.toArray().length; i++)
            for(int j = 0; j < list.toArray().length; j++)
                dist[i][j]=  distance(list.get(i).getLat(), list.get(i).getLongit(), list.get(j).getLat(), list.get(j).getLongit());
    }
    
    /**
     * Calculates distance
     * @param startLat - starting point latitude
     * @param startLong - starting pint longitudes
     * @param endLat - ending point latitude
     * @param endLong - ending pint longitudes
     * @return - returns distance
     */
    public static double distance(double startLat, double startLong,double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }
    
    /**
     * Calculate haversin
     * @param val
     * @return 
     */
    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    /**
     * Recursion to find path 
     * @param node - current point
     * @param beers - how many beer types found
     * @param dis - traveled distance
     * @param path - trave path
     * Starts at point 0(Home) and from there go to each beer brewers return 
     * back if distance is bigger then 2000 if at some node he cant return home 
     * then go back to previous node and it wont go back to same node twice 
     * because going strait to point then throw other nodes is shorter. If prom
     * current node we can reach Home and beer we have more beer types types 
     * then las tame and as new path and save its information 
     */
    private void findPath(int node, int beers, double dis, String path) {
        if(dis <= 2000)
        {
            if(node == 0 && beers > beerTypes)
            {
                beerTypes=beers;
                km = dis;
                pat = path;
                System.out.println(beerTypes + " " + km + " " + pat);
            }
            for(int i = 0; i <list.size(); i++)
            {
                if(i != node)
                {
                    if(dis+dist[node][0] > 2000)
                        break;
                    if(!path.contains(Integer.toString(i)) || i == 0)
                        findPath(i, beers+list.get(i).getBeerLength(), dis+Math.abs(dist[node][i]), path+Integer.toString(i)+" ");
                }
            }
        }
    }
    /**
     * Prints results to console
     */
    private void display() {
        int i, priv = 0;
        System.out.println("Found " + (pat.split(" ").length - 2)+ " beer factorys\n");
        for(String s : pat.split(" "))
        {
            i = Integer.parseInt(s);
            System.out.println("-> "+list.get(i).getBrew()+": "+list.get(i).getLat()+", "+list.get(i).getLongit()+ " distance "+(int)dist[priv][i]+"km");
            priv = i;
        }
        System.out.println("\nCollected " + beerTypes+ " beer types\n");
        for(String s : pat.split(" "))
        {
            if(list.get(Integer.parseInt(s)).getBeer() != null)
                for(String type: list.get(Integer.parseInt(s)).getBeer())
                {
                    System.out.println("-> "+type);
                }
        }
    }

}
