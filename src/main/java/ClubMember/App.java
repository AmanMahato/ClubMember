package ClubMember;


public class App 
{
    static final String INPUT_FILE = "src/Resources/input.json";
    static final String LOG = "src/Resources/output_log.txt";
    static final String MEMBERLIST = "src/Resources/output_memberList.txt";
    static ArrayList arrayList;
    static HashIndex hashIndex;

    public static void main( String[] args )
    {
        CommandParsing commandParsingRead = new CommandParsing('I',INPUT_FILE);
        CommandParsing commandParsingWriteLog = new CommandParsing('O',LOG);
        CommandParsing commandParsingWriteMember = new CommandParsing('O',MEMBERLIST);
        System.out.println(commandParsingRead.getNextLine()[2]);
        System.out.println(commandParsingRead.getNextLine()[2]);
        commandParsingWriteLog.writeLine("ID is missing");
    }


}
