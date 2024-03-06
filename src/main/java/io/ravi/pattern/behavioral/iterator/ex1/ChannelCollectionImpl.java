package io.ravi.pattern.behavioral.iterator.ex1;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {

    private List<Channel> channelList;

    public ChannelCollectionImpl() {
        this.channelList = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel channel) {
        this.channelList.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        this.removeChannel(channel);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum channelTypeEnum) {
        return new ChannelIteratorImpl(channelTypeEnum, channelList);
    }


    private class ChannelIteratorImpl implements ChannelIterator {
        private ChannelTypeEnum channelTypeEnum;
        private List<Channel> channelList;
        private int position;

        public ChannelIteratorImpl(ChannelTypeEnum channelTypeEnum, List<Channel> channelList) {
            this.channelTypeEnum = channelTypeEnum;
            this.channelList = channelList;
        }

        @Override
        public boolean hasNext() {
            while (position < channelList.size()) {
                Channel channel = channelList.get(position);
                if (channel.getChannelTypeEnum().equals(channelTypeEnum) || channelTypeEnum.equals(ChannelTypeEnum.ALL)) {
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel channel = channelList.get(position);
            position++;
            return channel;
        }
    }
}
