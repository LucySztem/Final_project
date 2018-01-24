package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Event;
import pl.coderslab.repository.EventDao;


@Component
public class EventConverter implements Converter<String, Event>{

    @Autowired
    private EventDao eventDao;

    public EventConverter() {
    }

    @Override
    public Event convert(String s) {
        Event event = eventDao.findById(Long.valueOf(s));
        return event;
    }
}
