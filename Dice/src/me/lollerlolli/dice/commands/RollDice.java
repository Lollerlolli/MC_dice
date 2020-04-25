package me.lollerlolli.dice.commands;


import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RollDice implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		int result;
		Random randomizer= new Random();
		
		if (arg3.length == 0) 
		{
		//regular dice 1 to 6
			result = randomizer.nextInt(6)+1;
		}
		else if (arg3.length == 1)
		{
		//random number 1 to arg3[0] or help
			int maxEyes; 
			
			//help
			if (arg3[0].equals("help")) 
			{
				sender.sendMessage("§c/rolldice: §eGenerates random number between 1 and 6\n"
									+"§c/rolldice number1: §eGenerates random number between 1 and 'number1'\n"	
									+"§c/rolldice number1 number2: §eGenerates random number between 'number1' and 'number2'");
				return false;
			}
			
			try 
			{
			//random number 1 to arg3[0]
				maxEyes = Integer.parseInt(arg3[0]);
			} 
			catch (NumberFormatException e) 
			{	
				sender.sendMessage("Bad input! Try '/rolldice help'!");
				return false;
			}
			
			result = randomizer.nextInt(maxEyes)+1;
		}
		else if (arg3.length == 2)
		{
			int minEyes, maxEyes; 
			
			try 
			{
				minEyes = Integer.parseInt(arg3[0]);
				maxEyes = Integer.parseInt(arg3[1]);
			} 
			catch (NumberFormatException e) 
			{
				sender.sendMessage("Bad input! Try '/rolldice help'!");
				return false;
			}
			result = minEyes + randomizer.nextInt(maxEyes-minEyes+1);
		}
		else	
		{
			sender.sendMessage("§c Too many arguments!  Try '/rolldice help'!");
			return false;
		}
			
			
		sender.sendMessage(Integer.toString(result));    
		
		return false;
	}

}
