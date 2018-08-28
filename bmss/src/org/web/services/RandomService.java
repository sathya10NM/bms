package org.web.services;

import java.util.Random;

public class RandomService {

	static String i;
	public static String print()
    {
		Random rand = new Random();
        i = String.format("%04d", rand.nextInt(10000));
        return i;
    }

}
 