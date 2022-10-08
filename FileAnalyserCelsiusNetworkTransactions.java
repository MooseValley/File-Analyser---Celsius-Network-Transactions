/*
................................
<= -1,000,000: 810 (0.0%)
<= -100,000: 12,459 (0.4%)
<= -10,000: 103,811 (3.3%)
<= -1,000: 210,862 (6.6%)
<= 0: 877,218 (27.6%)
<= 1,000: 1,720,006 (54.2%)
<= 10,000: 170,924 (5.4%)
<= 100,000: 71,040 (2.2%)
<= 1,000,000: 8,177 (0.3%)
<= 1.7976931348623157E308: 553 (0.0%)

3,175,860 transactions processed / tallied.


Following on from numerous posts on this topic, for example this from u/AmericanScream
- Celsius public court bankruptcy filings doxxes personal financial information on massive amount of (if not all) their customers. It's now public record. This is obviously good for Bitcoin, right?, https://www.reddit.com/r/Buttcoin/comments/xxlsoz/celsius_public_court_bankruptcy_filings_doxxes/


Celsius PDF transaction file - preliminary analysis

3,175,860 transactions

Transactions between -1,000 and 1,000: 2,597,224 (82%)
i.e. they exposed the private details (names and in many cases addresses) for tens of thousands of people for trivial transaction values, in many cases of a few dollars or so.

Transactions between -10,000 and 10,000: 2,979,010 (94%)

13,269 (0.4%) withdrawl transactions (or some kind of output transaction) for $100K or more.
117,080 (4%)  withdrawl transactions (or some kind of output transaction) for $10K or more.

I'm guessing these




*/
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/*
Page 13 of 13
22-10964-mg Doc 973 Filed 10/05/22 Entered 10/05/22 22:13:10 Main Document
Pg 46 of 14532

Debtor Name: Celsius Network LLC Case Number: 22-10964
USERNAME ADDRESS DATE ACCOUNT TYPE Descriptive Purpose COIN COIN QUANTITY COIN USD
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 4/15/2022 Custody Incoming Deposit ETH 0.03298523 $100.11
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 4/15/2022 Custody Incoming Deposit BTC 0.00246552 $99.86
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 4/15/2022 Custody Incoming Deposit ETH 194.96512477 $590,902.25
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 4/15/2022 Custody Incoming Deposit BTC 69.27272696 $2,804,457.51
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 4/22/2022 Custody Outgoing Loan Interest Payment BTC (0.02409700064) ($981.76)
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 4/30/2022 Custody Outgoing Loan Interest Payment BTC (0.008607219451) ($333.33)
007 CAPITAL LLC DORADO BEACH EAST, DORADO, 646 PUERTO RICO 5/6/2022 Custody Outgoing Loan Interest Payment BTC (0.02285938536) ($833.33)
:::
AARON BARTROP ADDRESS REDACTED 6/2/2022 Earn Incoming Swap In BTC 0.0001505 $4.50
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards BTC 0.0025533895015 $77.39
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards CEL 0.000035766694465 $0.00
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards ETH 0.041135009357 $81.52
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards MATIC 5.758783286386 $7.95
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards DOT 0.0077544510091 $0.09
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards LINK 3.61825673884293 $39.26
AARON BARTROP ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards SNX 8.2535903494 $28.20
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards BTC 0.00039423406442 $11.67
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards ETH 0.00121770156123 $2.38
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards USDC 0.023197002722 $0.02
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards MATIC 4.1970777977 $3.33
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards DOT 0.43989770962 $4.89
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards XLM 0.0000510876909289999 $0.00
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards LTC 0.000000126936901188 $0.00
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards AVAX 0.025964687448 $1.03
AARON BASS ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards BAT 0.0000099934592693 $0.00
AARON BAUMANN ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards BTC 0.000031686697306 $0.94
:::
ZZ II ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards BTC 0.00077283400425 $22.87
ZZ II ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards CEL 1.765532348055 $2.02
ZZ II ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards LTC 0.00759469339 $0.40
ZZ II ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards MCDAI 0.13864137561 $0.14
:::
   ADDRESS REDACTED 4/14/2022 - 7/13/2022 Earn - Interest; Earn, Custody or Withheld - Rewards Incoming Interest and Rewards BTC 0.00168851115340199 $50.22

*/

public class FileAnalyserCelsiusNetworkTransactions
{
   public static final String HEADER_LINE = "USERNAME ADDRESS DATE ACCOUNT TYPE Descriptive Purpose COIN COIN QUANTITY COIN USD";

   // Example use:
   //   double val = Moose_Utils.strToDouble ("$1,234.56", 0);
   public static double strToDouble (String sourceStr, double errorReturnVal)
   { // errorReturnVal will be returned of the conversion fails / errors.
      double resultVal = errorReturnVal;

      if ((sourceStr != null) && (sourceStr.length() > 0) )
      {
         int multiplier = 1;
         // (1234.56)  = a negative number !!!
         // (-1234.56) = a negative number !!!
         // -(1234.56) = a negative number !!!
         if (sourceStr.contains ("(") == true)
            multiplier = -1;

         // Remove common symbols that cause problems with the conversion:
         sourceStr = sourceStr.replace ("$",  "");
         sourceStr = sourceStr.replace (",",  "");
         sourceStr = sourceStr.replace (" ",  "");
         sourceStr = sourceStr.replace ("(",  "");
         sourceStr = sourceStr.replace (")",  "");

         try
         {
            resultVal = Double.parseDouble (sourceStr.trim());

            resultVal = multiplier * Math.abs (resultVal);
         }
         catch (NumberFormatException err)
         {
            resultVal = errorReturnVal;
         }
      }

      return resultVal;  // Return errorReturnVal if error or not found.
   }



   public static void main (String[] agrs)
   {
      boolean startExtraction = false;
      boolean quitProcessing  = false;
      long    lineCount       = 0;
      long    transCount      = 0;

      NumberFrequencyCount.initialiseCounts ();

      try (Scanner inFile = new Scanner (new FileReader ("Censius.txt") ) )
      {
         while ((inFile.hasNext() == true) && (quitProcessing == false) )
         {
            String lineStr = inFile.nextLine().trim();

            lineCount++;

            if (lineCount % 100_000 == 0)
               System.out.print (".");

            //if (lineCount > 10_000)
            //   quitProcessing = true;

            if (startExtraction = true)
            {
               if ((lineStr.startsWith ("Page ")             == true) ||
                   (lineStr.startsWith ("22-10964-mg Doc ")  == true) ||
                   (lineStr.startsWith ("Pg ")               == true) ||
                   (lineStr.startsWith ("")                 == true) ||
                   (lineStr.startsWith ("Debtor Name: ")     == true) )
               {
                  // Do nothing ...
               }
               else if (lineStr.startsWith ("Pg 14384 of 14532") == true)
               {
                  quitProcessing = true;
               }
               else
               {
                  int startIndex = lineStr.indexOf ("($");

                  if (startIndex < 0)
                     startIndex = lineStr.indexOf ("$");

                  if (startIndex > 0)
                  {
                     transCount++;

                     String numStr = lineStr.substring (startIndex, lineStr.length() );

                     double val = strToDouble (numStr, 0);

                     NumberFrequencyCount.incrementCounts (val);
                  }
               }
            }
            else if (lineStr.equals (HEADER_LINE) == true)
            {
               startExtraction = true;
            }
         }
      }
      catch (Exception err)
      {
         err.printStackTrace ();
      }

      System.out.println ();

      NumberFrequencyCount.displayFrequencyCounts ();
   }
}