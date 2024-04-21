package com.example.webflux.publisher;

import com.example.webflux.model.ItemModel;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class ItemUpdatePublisher {

    private final Sinks.Many<ItemModel> itemModelUpdateSink;

    public ItemUpdatePublisher() {
        this.itemModelUpdateSink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(ItemModel itemModel) {
        itemModelUpdateSink.tryEmitNext(itemModel);
    }

    public Sinks.Many<ItemModel> getUpdateSink() {
        return itemModelUpdateSink;
    }

}
