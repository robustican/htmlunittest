describe("A suite is just a function", function() {
  var a;

  it("and so is a spec", function() {
    a = true;

    expect(a).toBe(true);
  });
});


describe("Test fixtures", function() {

  it("try the sandbox", function() {
    //loadFixtures('f.html');
    sandbox();
    expect($('#sandbox').html()).toBe(null);
  });

  it("try loading a fixture", function() {
    loadFixtures('f.html');
    expect($('#my-fixture').html()).toBe('some complex content here');
  });


  it("try loading a fixture and using d3", function() {
    loadFixtures('f.html');
    d3.select("#my-fixture")
  });
});

