package Blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlocksFactory {
    private static BlocksFactory f;
    private Map<String, Class<Block>> blocksMap;
    private static final Logger logger = Logger.getLogger(BlocksFactory.class.getName());

    public BlocksFactory() {
        try {
            blocksMap = new HashMap<>();
            Properties properties = new Properties();
            properties.load(BlocksFactory.class.getResourceAsStream("blocks.properties"));
            properties.forEach((key, value) -> {
                try {
                    blocksMap.put(key.toString(), (Class<Block>) Class.forName(value.toString()));
                } catch (ClassNotFoundException e) {
                    logger.log(Level.SEVERE, e.toString(), e);
                }
            });

        } catch(Exception e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }
    }

    public static BlocksFactory getInstance() {
        BlocksFactory newF = f;
        if (f == null) {
            newF = new BlocksFactory();
            f = newF;
        }
        return newF;
    }

    public Block getBlock(final String name) {
        try {
            Class<Block> currentConstructor = blocksMap.get(name);
            if (currentConstructor == null)
                throw new ClassNotFoundException();
            return currentConstructor.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

}
