const config = require('semantic-release-preconfigured-conventional-commits')

const publishCommands = `
./gradlew uploadJavaOSSRHToMavenCentralNexus releaseStagingRepositoryOnMavenCentral || exit 1
./gradlew publishJavaOSSRHPublicationToGitHubRepository || exit 2
`
const releaseBranches = ["main"]

config.branches = releaseBranches

config.plugins.push(
    // Custom release commands
    ["@semantic-release/exec", {
        "publishCmd": publishCommands,
    }],
    "@semantic-release/github",
    "@semantic-release/git",
)

module.exports = config