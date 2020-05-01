/**
 * This interface was taken from https://www.algosome.com/articles/java-jcombobox-autocomplete.html
 * 
 * Implementation of the Searchable interface that searches a List of String
 * objects.
 * 
 * This implementation searches only the beginning of the words, and is not be
 * optimized
 * 
 * for very large Lists.
 * 
 * @author G. Cope
 *
 */
package frontend.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import backend.classes.*;

/**
 * 
 * StringSearchable class that implements the Searchable
 * interface
 *
 */
public class StringSearchable implements Searchable<String, String> {

   private List<String> terms = new ArrayList<String>();

   /**
    * 
    * Constructs a new object based upon the parameter terms.
    * 
    * @param testNames The inventory of terms to search.
    * 
    */
   public <T> StringSearchable(List<T> testNames) {

      for(T test: testNames) {
    	  terms.add(test.toString());
      }

   }
   

   @Override
   public Collection<String> search(String value) {
      List<String> founds = new ArrayList<String>();

      for (String s : terms) {
         if (s.indexOf(value) == 0) {
            founds.add(s);
         }
      }

      return founds;
   }
}
