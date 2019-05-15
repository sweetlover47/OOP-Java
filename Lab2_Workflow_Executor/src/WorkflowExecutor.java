import Blocks.Block;
import Blocks.BlocksFactory;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkflowExecutor {
    private static final Logger logger = Logger.getLogger(WorkflowExecutor.class.getName());
    void work(String inputFile) {
        try {
            WorkflowReader wfReader = new WorkflowReader(inputFile);
            logger.log(Level.FINE, "WorkflowReader return success");
            BlocksFactory blocksFactory = new BlocksFactory();
            blocksFactory.getInstance();
            logger.log(Level.FINE, "BlockFactory return success");
            String result = null;
            Map<Integer, BlockContext> map = wfReader.readBlock();
            List<Integer> pipeline = wfReader.readBlockPipe();
            logger.log(Level.FINE, "Starting execute pipeline");
            for (Integer blockID: pipeline) {
                String currentBlockName = map.get(blockID).getCommand();
                String[] currentBlockArgs = map.get(blockID).getArgs();
                Block currentBlock = blocksFactory.getBlock(currentBlockName);
                if (currentBlock != null)
                    result = currentBlock.execute(currentBlockArgs, result);
                logger.log(Level.FINER, currentBlockName + " execute correctly");
            }
            logger.log(Level.FINE, "End of working");

        }
        catch(Exception e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }
    }
}
