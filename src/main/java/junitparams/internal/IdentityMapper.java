package junitparams.internal;

import java.io.*;
import java.util.*;

import junitparams.*;

/**
 * A mapper, that maps contents of a file to a set of parameters for test
 * methods. Basically a CSV with no header and ordering of columns exactly like
 * the one in the test methods.
 * 
 * It uses the logic from @Parameters({}) for parsing lines of file, so be sure
 * the columns in the file match exactly the ordering of arguments in the test
 * method.
 * 
 * @author Pawel Lipinski
 * 
 */
public class IdentityMapper implements DataMapper {
    @Override
    public Object[] map(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        String line;
        List<String> result = new LinkedList<String>();
        try {
            try {
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
                return result.toArray();
            } finally {
                reader.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}