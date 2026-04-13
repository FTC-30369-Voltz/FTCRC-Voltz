# Roadmap

## Ideas
- BoardMeeting: Add Limelight 3A wrapper
  - I'm not sure if this is still relevant due to us using a tank drive system for LOKI.
- AutoCommander: Add support for Road Runner or Pedro Pathing
  - This may or may not require a rework of the rest of the code...
  - (UPDATE: It's possible to implement custom BotCommands, so this shouldn't require *that* big of a refactor to AutoCommander.)
  - I'm also going to need to decide which library would be best to use. I know Brian (our previous programmer) wanted to use Pedro, so I'm considering that.

## Todo
- [ ] TeamCode/Auto: Set up an Autonomous OpMode
- [ ] AutoCommander work
  - [ ] Wire up AutoCommander to BoardMeeting
    - [ ] Get Move command to steer drive base
    - [ ] Connect ITO class to AutoCommander ShootArtifact command

## Doing / Done
- [x] Implement robot hardware management library (BoardMeeting)
- [x] Start work on autonomous command system (AutoCommander)
- [x] TeamCode: Set up the robot's program board
- [x] TeamCode/Tele: Set up a TeleOp OpMode
  - As far as I know, Sam from drive team requested that each control stick control a different motor. 