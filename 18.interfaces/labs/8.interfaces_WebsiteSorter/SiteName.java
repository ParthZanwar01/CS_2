//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import org.jetbrains.annotations.NotNull;

import static java.lang.System.*;

class SiteName implements Comparable<SiteName>
{

    //add instance variables
	private String website;
	
	//add a constructor
    public SiteName(String web){
        website = web;
    }

	//add a compareTo

    public int compareTo(SiteName other) {

        if (getEnd().compareToIgnoreCase(other.getEnd()) == 0){
            return website.compareToIgnoreCase(other.website);
        }
        return getEnd().compareToIgnoreCase(other.getEnd());
    }

	//add a toString
    public String toString(){
        return website;
    }

    public String getEnd(){
        return website.substring(website.length()-4);
    }

}

