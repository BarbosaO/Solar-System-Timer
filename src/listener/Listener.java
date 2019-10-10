package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.ZonedDateTime;

public class Listener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		System.out.println(ZonedDateTime.now().getHour());
		System.out.println(ZonedDateTime.now().getMinute());
		System.out.println(ZonedDateTime.now().getSecond());
		
			
	}

}
