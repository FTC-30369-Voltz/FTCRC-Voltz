# Roadmap

## Ideas
- AutoCommander: Add support for Road Runner or Pedro Pathing
  - This may or may not require a rework of the rest of the code...
  - (UPDATE: It's possible to implement custom BotCommands, so this shouldn't require *that* big of a refactor to AutoCommander.)
  - I'm also going to need to decide which library would be best to use. I know Brian (our previous programmer) wanted to use Pedro, so I'm considering that.

## Todo

## Doing / Done
- [x] Implement robot hardware management library (BoardMeeting)
- [x] Start work on autonomous command system (AutoCommander)
- [x] TeamCode: Set up the robot's program board
- [x] TeamCode/Tele: Set up a TeleOp OpMode
  - As far as I know, drive team requested that each control stick control a different motor. 
- [ ] TeamCode/Auto: Set up an Autonomous OpMode
- [ ] Autonomous/AutoCommander work
    - [ ] Wire up AutoCommander to BoardMeeting
        - [ ] Move and Turn commands
        - [ ] Connect ITO class to IntakeArtifact and ShootArtifact commands
    - [ ] Figure out whether have each command run in "passthrough" or stop the rest of the Auto OpMode when run
        - [ ] Passthrough may come in handy for running commands in parallel (such as Move and IntakeArtifact)