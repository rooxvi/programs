package io.ravi.pattern.behavioral.iterator.ex1;

public class Channel {
    private double frequency;
    private ChannelTypeEnum channelTypeEnum;

    public Channel(double frequency, ChannelTypeEnum channelTypeEnum) {
        this.frequency = frequency;
        this.channelTypeEnum = channelTypeEnum;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getChannelTypeEnum() {
        return channelTypeEnum;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "frequency=" + frequency +
                ", channelTypeEnum=" + channelTypeEnum +
                '}';
    }
}
