package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class TlvDecoder {
	
	public static void main(String[] args) {
		
		parseTLV("9F2608F16E008C03B4DB7C9F2701809F10200FB501A4004000000100080000000290690000000000000000000000000000009F3704EF7D1C989F36020149950500000000009A032005129C01289F02060000000013005F2A0203569F1A020356820219009F3303E0F8C89F34031F03029F03060000000000008407A00000052410109F080200029F090200029F3501229F4C08DA82E0B9DC4565329B02E8005F340101500D527550617920507265706169645F20165255504159202054455354204341524431202020202F8E0E000000000000000042031F031E03");
	}

	 public static Map<String, String> parseTLV(String tlv) {
	        Map<String, String> hashMap = new HashMap<>();

	        if (tlv == null) {
	            return hashMap;
	        }

	        if (tlv.length() % 2 != 0) {
	            throw new RuntimeException("Invalid tlv, null or odd length");
	        }

	        for (int i = 0; i < tlv.length();) {
	            try {
	                String key = tlv.substring(i, i = i + 2);

	                if ((Integer.parseInt(key, 16) & 0x1F) == 0x1F) {
	                    // extra byte for TAG field
	                    key += tlv.substring(i, i = i + 2);
	                }
	                String len = tlv.substring(i, i = i + 2);
	                int length = Integer.parseInt(len, 16);

	                if (length > 127) {
	                    // more than 1 byte for length
	                    int bytesLength = length - 128;
	                    len = tlv.substring(i, i = i + (bytesLength * 2));
	                    length = Integer.parseInt(len, 16);
	                }
	                length *= 2;

	                String value = tlv.substring(i, i = i + length);
	                // System.out.println(key+" = "+value);
	                hashMap.put(key, value);
	            } catch (NumberFormatException e) {
	                throw new RuntimeException("Error parsing number", e);
	            } catch (IndexOutOfBoundsException e) {
	                throw new RuntimeException("Error processing field", e);
	            }
	        }

	        return hashMap;
	    }

}
