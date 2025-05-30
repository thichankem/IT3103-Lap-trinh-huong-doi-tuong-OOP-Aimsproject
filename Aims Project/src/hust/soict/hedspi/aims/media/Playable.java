package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public interface Playable 
{
	public StringBuffer play() throws PlayerException;
}