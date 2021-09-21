package io.jsonwebtoken.impl;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;

public class CompressionCodecLocator<H extends Header<H>> implements Function<H, CompressionCodec> {

    private final CompressionCodecResolver resolver;

    public CompressionCodecLocator(CompressionCodecResolver resolver) {
        this.resolver = Assert.notNull(resolver, "CompressionCodecResolver cannot be null.");
    }

    @Override
    public CompressionCodec apply(H header) {
        return resolver.resolveCompressionCodec(header);
    }
}
