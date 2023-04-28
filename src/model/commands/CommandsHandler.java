package src.model.commands;

public class CommandsHandler {
    public static Command getCommand(Commands commands) throws NoCommandException {
        return switch (commands) {
            case CHASE -> new ChaseCommand();
            case CATCH_BALL -> new CatchBallCommand();
            case CATCH_MOUSE -> new CatchMouseCommand();
            case FREEZE -> new FreezeCommand();
            default -> throw new NoCommandException(commands.toString());
        };
    }
}
