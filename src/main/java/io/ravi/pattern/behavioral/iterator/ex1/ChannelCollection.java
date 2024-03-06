package io.ravi.pattern.behavioral.iterator.ex1;

public interface ChannelCollection {
    void addChannel(Channel channel);
    void removeChannel(Channel channel);
    ChannelIterator iterator(ChannelTypeEnum channelTypeEnum);
}
