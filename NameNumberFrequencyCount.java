/*
NameNumberFrequencyCount.initialise ();

NameNumberFrequencyCount.incrementCounts ("Mike", 123);
NameNumberFrequencyCount.incrementCounts ("Mike", 67891);
NameNumberFrequencyCount.incrementCounts ("Frankie", 4433);
:::
System.out.println (NumberFrequencyCount.getFrequencyCounts () );

*/
import java.util.ArrayList;

class UniqueNamesPerFrequency
{
   private ArrayList<String> uniqueNamesArrayList;

   public UniqueNamesPerFrequency ()
   {
      uniqueNamesArrayList = new ArrayList<>();
   }

   public void add (String nameStr)
   {
      if ((nameStr != null) && (nameStr.length() > 0) )
         Moose_Utils.addUniqueItemToArrayList (uniqueNamesArrayList, nameStr, false); // Case insensitive.
   }

   public int size()
   {
      return uniqueNamesArrayList.size();
   }
}



public class NameNumberFrequencyCount
{

   public static double[] FREQUENCY_LIMITS = {-1_000_000, -100_000, -10_000, -1000, 0, 1000, 10_000, 100_000, 1_000_000, Double.MAX_VALUE};
   public static long[]   frequencyCounts;
   public static UniqueNamesPerFrequency[] uniqueNamesPerFrequency;
   public static long     transCount;

   public static void initialise ()
   {
      frequencyCounts         = new long                    [FREQUENCY_LIMITS.length];
      uniqueNamesPerFrequency = new UniqueNamesPerFrequency [FREQUENCY_LIMITS.length];


      for (int k = 0; k < frequencyCounts.length; k++)
      {
         frequencyCounts [k]        = 0;
         uniqueNamesPerFrequency[k] = new UniqueNamesPerFrequency();
      }

      transCount = 0;
   }

   public static void incrementCounts (String nameStr, double val)
   {
      for (int k = 0; k < FREQUENCY_LIMITS.length; k++)
      {
         if (val <= FREQUENCY_LIMITS [k])
         {
            transCount++;
            frequencyCounts [k]++;
            uniqueNamesPerFrequency [k].add (nameStr);

            k = FREQUENCY_LIMITS.length; // Exit Loop
         }
      }
   }

   public static String getFrequencyCounts ()
   {
      StringBuffer sb = new StringBuffer ();

      sb.append ("\n" + "Frequency Counts:" + "\n");

      for (int k = 0; k < frequencyCounts.length; k++)
      {
         double proportion = 100.0 * frequencyCounts [k] / transCount;

         if (FREQUENCY_LIMITS [k] < 1_000_000_000_000L)
         {
            sb.append ("<= " + String.format ("%,.0f", FREQUENCY_LIMITS [k]) );
         }
         else
         {
            sb.append ("<= " + FREQUENCY_LIMITS  [k]);
         }

         sb.append (": "  + String.format ("%,d",   frequencyCounts  [k])            +
                    " ("  + String.format ("%,.1f", proportion)                      + "%)" +
                    ", Unique Names: "
                          + String.format ("%,d",   uniqueNamesPerFrequency[k].size() ) + "\n");
      }

      sb.append ("\n" + String.format ("%,d", transCount) + " transactions processed / tallied." + "\n");

      System.out.println (sb.toString() );

      return sb.toString();
   }

}