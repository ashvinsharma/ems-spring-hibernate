package com.ems.hibernate.utils;

import com.ems.hibernate.model.Designation;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DesignationConverter implements Converter<String, Designation> {
    @Override
    public Designation convert(String source) {
        Matcher matcher = Pattern.compile("(\\w{0,3} \\S{1,2})[,|\\]]").matcher(source); //old regex for future reference [ ](\\S{1,2})[,|\\]]")
        List<String> result = new ArrayList<>();                                         //didn't consider first group of sequence in "SDE I"
        while (matcher.find()) result.add(matcher.group(1).trim());
        return new Designation(Integer.parseInt(result.get(0)), result.get(1));
    }
}
