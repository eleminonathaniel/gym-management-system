
package bank.account.monthly.update.system;

import javax.swing.JOptionPane;  
import java.text.DecimalFormat;


public class Duba_Bank_Account_Monthly_Update_System {

  
    public static void main(String[] args) {       // declare variable
       
        String output;
        String accountTypeStr;
        String currentBalanceStr;
        String minimumBalanceStr;
        
        double excess;
        double currentBalance;
        double minimumBalance;
        double serviceCharge = 0;
        double interest = 0;
        double newBalance = 0;
        
        
        
        // input data
       accountTypeStr = JOptionPane.showInputDialog("Enter Account Type: (S) Saving  (C) Checking: ");
       currentBalanceStr = JOptionPane.showInputDialog("Enter Current Balance: ");
       minimumBalanceStr = JOptionPane.showInputDialog("Enter Minimum Balance: ");
       
       // parsing
       currentBalance = Double.parseDouble(currentBalanceStr );
       minimumBalance = Double.parseDouble(minimumBalanceStr);
       
       
       //checking account 
       if (accountTypeStr.equalsIgnoreCase("C")){
           
          if (currentBalance < minimumBalance) {
             serviceCharge = 25;
             newBalance = currentBalance - serviceCharge;
             
            }else{
             if (currentBalance >= minimumBalance ){
                 excess = currentBalance - minimumBalance;
                 if (excess > 5000) {
                     interest = currentBalance * 0.05;
                  
                 }else{
                 interest = currentBalance * 0.03;
                 
                 }
                  newBalance = currentBalance + interest;
             }
 
             
          }
          
  
         // saving account
       }else{
           if ( currentBalance < minimumBalance){
             serviceCharge = 10.00;
             newBalance = currentBalance - serviceCharge;
           }else{
             if (currentBalance >= minimumBalance ){
                  interest = currentBalance * 0.04;
                  newBalance = currentBalance + interest;
             
             }
          
           }
      
       }
        DecimalFormat df = new DecimalFormat("#.00");
       // diplay output
       output = "Service Charge: " + df.format(serviceCharge) + "\n" + 
                "Interest Earned: " + df.format(interest) + "\n" +
                "Final Account Balance: " + df.format(newBalance);
       
       
       JOptionPane.showMessageDialog(null,output,"Bank Account Monthly Update System",JOptionPane.INFORMATION_MESSAGE);
       
    }
}
    