# Welcome to My Capstone: Transactions Tracker!

This was our first Capstone it was one for the record books! Filled with many ups and down. I extremely excited about being able to finish the project even if it was not fully on time. I learned a lot about myself this whole week lots of things I will need to improve on like managing my time better and making sure I break up the projects into smaller Pieces.  <br>

In the link below I was able to plan out what my application would look like.

           
[Lucid](https://lucid.app/lucidspark/22a0c509-efe9-40ae-8f8a-3a4bee7b92e0/edit?beaconFlowId=F69AAC6FF5805F1D&invitationId=inv_dcb1bb6b-2aab-48fb-a5ff-4dddf34b2895&page=0_0#  "Project planning on Lucid")


## Description 
I wanted to plan out a a few different screens. Starting with the home page. With options for user to add deposits to our csv, and the same thing but just for payments. Third options "L" takes user to a new screen that gives user options to do actions that show all transactions ("A"), shows all deposits ("D"), and all payments ("P"), there would also be an option Ledger ("L") that takes user to another screen where they can have pre-defined searches, and lastly ("H") would take the user to the home screen. In the Ledger Screen users get the option to search our csv for all transactions within the month, all transactions from previous month, transactions from year to day, and transactions from previous year. If user is done with this screen the have an option to go back to the reports screen by entering "R".


## One of my favorite parts of code in my propgram is below:
I was able to go through the csv file line by line to separate each line, and it was super helpful. <br>


 public class FileReader {
    public static List<Transactions> csvReader(String filename){
    List<Transactions> transactions = new ArrayList<>();
    File file = new File(filename);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    try (Scanner scanner = new Scanner(file)){
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String [] parts = line.split("\\|");
            LocalDate date = LocalDate.parse(parts[0], dateFormatter);
            LocalTime time = LocalTime.parse(parts[1].trim(), timeFormatter);
            String description = parts[2].trim();
            String vendor = parts[3].trim();
            double amount = Double.parseDouble(parts[4].trim());
            Transactions transaction = new Transactions(date, time, description, vendor, amount);
            transactions.add(transaction);

        }
    }catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException exception){
        System.out.println("Sorry there was a problem: " + exception.getMessage());
    }

        return transactions;
    }

