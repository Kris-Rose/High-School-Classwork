//3
public class Team
{
    private Player[] players;
    
    public Team(){
        players = new Player[9];
    }
    
    public Team(int numPlayers){
        players = new Player[numPlayers];
    }
    
    public void printTeamStats(){
        for(int a = 0; a<players.length; a++){
            System.out.println(players[a].getName() + "  #" + players[a].getNumber() + "  average >>> " + players[a].getBattingAverageString());
        }
        
    }
    
    public Player getPlayer(int index){
        return players[index];
    }
    
    public int teamLength(){
        return players.length;
    }
    
    public void addPlayer(Player p, int index){
        players[index] = p;
    }
    
}
