// Event listener for the copy button
document.getElementById('copyUUID').addEventListener('click', function() {
    var textToCopy = document.getElementById('textToCopy');
    var range = document.createRange();
    range.selectNode(textToCopy);
    window.getSelection().removeAllRanges();
    window.getSelection().addRange(range);
    document.execCommand('copy');
    window.getSelection().removeAllRanges();
    // Change button text to "Copied" after text is copied
    document.getElementById('copyUUID').textContent = 'Copied';
    // Reset button text after 1.5 seconds
    setTimeout(function() {
        document.getElementById('copyUUID').textContent = 'Copy';
    }, 2000);
});



function copyTableData() {
    var table = document.querySelector('table');
    var range = document.createRange();
    range.selectNode(table);
    window.getSelection().removeAllRanges();
    window.getSelection().addRange(range);
    document.execCommand('copy');
    window.getSelection().removeAllRanges();
    document.getElementById('copyTable').innerText = 'Copied!';
    setTimeout(function() {
        document.getElementById('copyTable').textContent = 'Copy';
    }, 2000);
}

document.addEventListener('DOMContentLoaded', function() {
  var dropdown = document.querySelector('.dropdown');
  var dropdownContent = document.querySelector('.dropdown-content');

  dropdown.addEventListener('click', function(event) {
    dropdown.classList.toggle('clicked');
    event.stopPropagation(); // Prevents the event from bubbling up to the document
  });

  document.body.addEventListener('click', function(event) {
    if (!dropdown.contains(event.target)) {
      dropdown.classList.remove('clicked');
    }
  });
});

document.getElementById("downloadButton").addEventListener("click", function() {
    // Get the table element
    var table = document.getElementById("dataTable");

    // Initialize text variable
    var textData = "";

    // Traverse through the rows of the table
    for (var i = 0, row; row = table.rows[i]; i++) {
        // Traverse through the cells of the row
        for (var j = 0, cell; cell = row.cells[j]; j++) {
            // Append cell text to the textData variable
            textData += cell.textContent.trim() + "\t"; // Tab-separated
        }
        // Append a new line after each row
        textData += "\n";
    }

    // Create a Blob with the data
    var blob = new Blob([textData], { type: "text/plain" });

    // Create a link element
    var a = document.createElement("a");
    a.href = window.URL.createObjectURL(blob);

    // Set the file name
    a.download = "UUIDs.txt";

    // Append the link to the body
    document.body.appendChild(a);

    // Simulate a click on the link to trigger the download
    a.click();

    // Remove the link from the body
    document.body.removeChild(a);
});